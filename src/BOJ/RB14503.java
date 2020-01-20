package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RB14503 {
	static int n,m,sd,sy,sx,dep,ans;
	static boolean flag;
	static int map[][];
	static boolean v[][];
	static int dr[][] = {{-1,0},{0,1},{1,0},{0,-1}}; 
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void go() {
		if(map[sy][sx]==0) ans++;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(sy,sx,sd));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			//System.out.printf("%d %d %d\n",dot.y,dot.x,dot.d);
			flag = false;
			int nd = dot.d;
			for(int i=1;i<=4;i++) {
				nd = (nd + 3)%4; //여기 모르겟다 
				int ny = dot.y + dr[nd][0];
				int nx = dot.x + dr[nd][1];
				if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] || map[ny][nx] == 1)  {
					continue;
				}
				flag = true;
				//map[ny][nx] = ++ans;
				//System.out.printf("%d %d d:%d dep:%d\n",ny,nx,nd,dep);
				v[ny][nx] = true; //청소 
				ans++;
				q.add(new Dot(ny,nx,nd));
				break;
			}
			if(!flag) {
				
				int rd=(dot.d+2)%4;
				int ry = dot.y + dr[rd][0];
				int rx = dot.x + dr[rd][1];
				//System.out.printf("후진할 좌표 %d %d %d \n",ry,rx,rd);
				if(ry >= 0 || rx >= 0 || ry < n || rx < m) {
					if(map[ry][rx] != 1) {
						q.add(new Dot(ry,rx,dot.d)); //바라보는방향유지 
					}
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		v = new boolean[n][m];
		sy = sc.nextInt();
		sx = sc.nextInt();
		sd = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		v[sy][sx] = true;
		ans = 0;
		go();
		//print();
		System.out.println(ans);
	}
	static class Dot{
		int y;
		int x;
		int d;
		public Dot(int y,int x,int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
