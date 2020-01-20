package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16441 {
	static int N,M;
	static LinkedList<Dot> li;
	static char map[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean v[][];
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == '.' && !v[i][j]) System.out.print('P');
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void print2() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(v[i][j]) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
	}
	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		for(int i=0;i<li.size();i++) {
			q.add(li.get(i));
		}
		//System.out.println(q.size());
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(ny < 0 || nx < 0 || nx >= N || ny >= M) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny] == '#') {
					//v[nx][ny] = true;
					continue;
				}
				//System.out.printf("%d,%d\n",dot.x,dot.y);
				if(map[nx][ny] == '+') { //미끄러짐 
					//v[nx][ny] = true;
					System.out.printf("방문  %d,%d\n",nx,ny);
					int sx = nx;
					int sy = ny;
					while(true) {
						int mx = sx + dr[i][0];
						int my = sy + dr[i][1];
						if(map[mx][my]=='#') {
							v[sx][sy] = true;
							System.out.printf("방문  %d,%d\n",sx,sy);
							//System.out.printf("큐에 추가 %d,%d\n",sx,sy);
							q.add(new Dot(sx,sy));
							break;
						}else { //끝까지 이동하기 
							sx = mx;
							sy = my;
						}
					}
				}
				else {
					//System.out.printf("%d,%d %d,%d\n",dot.x,dot.y,nx,ny);	
					System.out.printf("방문  %d,%d\n",nx,ny);

					v[nx][ny] = true;
					q.add(new Dot(nx,ny));	
				}
			}
			//System.out.println(q.size());
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M];
		li = new LinkedList<Dot>();
		String s1 = sc.nextLine();
		for(int i=0;i<N;i++) {
			String s = sc.nextLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'W') li.add(new Dot(i,j));
			}
		}
		bfs();
		print();
		//print2();
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
