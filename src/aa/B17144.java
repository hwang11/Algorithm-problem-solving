package aa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17144 {
	static Queue<Dot> q; 
	static int R,C,T,ux,uy,dx,dy,t;
	static int map[][][];
	static int copy[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int cnt = 0;
				if(map[i][j][t] == 0) continue;
				for(int k=0;k<4;k++) {
					int nx = i + dr[k][0];
					int ny = j + dr[k][1];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					if(nx == ux && ny == uy) continue;
					if(nx == dx && ny == dy) continue;
					map[nx][ny][t+1] += map[i][j][t]/5;
					cnt++;
				}
				map[i][j][t+1] +=  map[i][j][t] - (map[i][j][t]/5)*cnt;
			}
		}
			
		
	}
	static void rotate() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copy[i][j] = map[i][j][t+1];
			}
		}
		for(int i=1;i<C-1;i++) {
			copy[ux][i+1] = map[ux][i][t+1];
			copy[dx][i+1] = map[dx][i][t+1];
		}
		for(int i=ux;i>0;i--) {
			copy[i-1][C-1]= map[i][C-1][t+1];
		}
		for(int i=dx;i<R-1;i++) {
			copy[i+1][C-1] = map[i][C-1][t+1];
		}
		for(int i=C-1;i>0;i--) {
			copy[0][i-1] = map[0][i][t+1];
			copy[R-1][i-1] = map[R-1][i][t+1];
		}
		for(int i=0;i<ux-1;i++) {
			copy[i+1][0] = map[i][0][t+1];
		}
		for(int i=R-1;i>dx+1;i--) {
			copy[i-1][0] = map[i][0][t+1];
		}
		
		copy[ux][1] = 0;
		copy[dx][1] = 0;
	}
	static void copy() {

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j][t+1] = copy[i][j];
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		int ans = 0;
		map = new int[R][C][T+1];
		copy = new int[R][C];
		boolean flag = false;
		q = new LinkedList<Dot>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j][0] = sc.nextInt();
				if(map[i][j][0]>0) q.add(new Dot(i,j));
				if(map[i][j][0] == -1) {
					if(flag) {
						dx = i;
						dy = j;
					}
					else ux = i; uy = j;
					flag = true;
				} 
			}
		}
		t = 0;
		while(t<T) {
			spread();
			rotate();
			copy();
			t++;
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j][T] > 0)ans += map[i][j][T];
			}
		}
		System.out.println(ans);
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
