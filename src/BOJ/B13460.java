package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13460 {
	static int n, m, cnt, ans, x, y;
	static char map[][];
	static boolean v[][];
	static boolean flag;
	static int dis[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static int bfs(int ry,int rx, int by,int bx) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(ry,rx,-1)); //방향 초기값 -1 
		v[ry][rx] = true;
		Dot dot = new Dot(0,0,0);
		int bd = -1;
		int rd = -2;
		while(!q.isEmpty() ) {
			//System.out.println("while문 시작 ");
			dot = q.poll();
			//System.out.printf("dot.y: %d dot.x %d\n",dot.y,dot.x);
			if(cnt >= 10) return -1;
			if(by == y && bx == x) return -1; //파란공이 빠지면 함수 종료 
			if(dot.y == y && dot.x == x) {
				System.out.println("빨간공 성공 ");
				flag = true; //빨간공이 구멍에 가도 그 이후에 파란공이 구멍에 빠질 수 있음 
			}
			for(int i=0;i<4;i++) {
				int nry = dot.y + dis[i][0];
				int nrx = dot.x + dis[i][1];
				if(nry < 0 || nrx < 0 || nry >= n || nrx >= m) continue;
				if(v[nry][nrx]) {
					continue;
				}
				//system.out.printf("nry: %d nrx %d %c\n",nry,nrx,map[nry][nrx]);
				//System.out.printf("dot.y,dot.y %d,%d %d,%d i: %d\n",dot.y,dot.x,nry,nrx,i);

				if(nry == y && nrx == x) {
					map[dot.y][dot.x] = '.';
					flag = true;
					cnt++;
					System.out.printf("성공시 cnt %d\n",cnt);

					break;
				}
				else if(map[nry][nrx] == '.') {
					int nby = by + dis[i][0];
					int nbx = bx + dis[i][1];
					if(dot.d != i) {
						cnt++; // 방향이 달라지면 
						rd = i;
						//System.out.printf("%d 와 %d\n",dot.d,i);
					}
					v[nry][nrx] = true;
					//System.out.printf("%d , %d\n",nry,nrx);
					map[dot.y][dot.x] = '.'; //지나간 자리 .으로 
					map[nry][nrx] = 'R';
					q.add(new Dot(nry,nrx,i));
					//System.out.printf("nry: %d nrx %d\n",nry,nrx);
					if(nbx > 0 && nby > 0 && nby < n && nbx < m) {
						if(map[nby][nbx] == '.') {
							by = nby;
							bx = nbx;
							bd = i;
						}
						else if(nby == y && nbx == x) return -1; //여기서도 체크 필요할거같은데.. 모르겟 
					}
				}
				else continue;
			}
		}
//		System.out.printf("dot.y: %d dot.x %d\n",dot.y,dot.x);
//		System.out.println(by+","+bx);
//		System.out.println("flag: "+flag);
		
		Queue<Dot> q2 = new LinkedList<Dot>();
		if(bd == rd){
			//System.out.println("같다 ");
			q2.add(new Dot(by,bx,bd));
			while(!q2.isEmpty()) {
				Dot dot2 = new Dot(0,0,0);
				dot2 = q2.poll();
				int nby = dot2.y + dis[bd][0];
				int nbx = dot2.x + dis[bd][1];
				//System.out.printf("파란공 자취 %d,%d %c\n",nby,nbx,map[nby][nbx]);

				if(nby < 0 || nbx < 0 || nby >= n || nbx >= m) continue;
				if(nby == y && nbx == x) {
					//System.out.println("파란공 구멍 ");
					flag = false;
					break;
				}
				if(map[nby][nbx] == '.') {
					//System.out.println("q에 추가 ");
					q2.add(new Dot(nby,nbx,bd));
				}
			}
		}
		if(flag) return cnt;
		else return -1; 
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int ry, rx, by, bx;
		ry = rx = by = bx = 0;
		map = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				char item = map[i][j] = s.charAt(j);
				switch (item) {
				case 'O':
					y = i;
					x = j;
					break;
				case 'B':
					by = i;
					bx = j;
					break;
				case 'R':
					ry = i;
					rx = j;
					break;
				default:
					break;

				}
			}
		}

		flag = false;
		if (bfs(ry, rx, by, bx) == -1)
			System.out.println(-1);
		else
			System.out.println(cnt);
		//System.out.println("flag: " + flag);
	}

	public static class Dot {
		int y;
		int x;
		int d;

		public Dot(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;

		}
	}
}
