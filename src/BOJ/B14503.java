package BOJ;

import java.util.Scanner;

public class B14503 {
	static int n,m,sd,sy,sx,dep,ans;
	static boolean flag;
	static int map[][];
	static boolean v[][];
	static int dr[][] = {{-1,0},{0,-1},{1,0},{0,1}}; //북서남동 상좌하우 
	static void go(int y,int x,int cnt,int d) {
		if(flag) return;
		if(dep == 4) {
		 //후진 
			int rd=(d+2)%2;
			int ry = y + dr[rd][0];
			int rx = x + dr[rd][1];
			if(ry < 0 || rx < 0 || ry >= n || rx >= m || v[ry][rx] || map[ry][rx] == 1) {
				ans = cnt;
				flag = true;
				return; //후진불가능 
			}
			go(ry,rx,cnt,rd);
		}
		int nd = (d+1)%4; //왼쪽탐색  
		int ny = y + dr[nd][0];
		int nx = x + dr[nd][1];
		if(ny < 0 || nx < 0 || ny >= n || nx >= m) { //dep 증가?
			dep++;
			return;
		}
		if(v[ny][nx] || map[ny][nx] == 1) {
			dep++;
			go(ny,nx,cnt,nd);
		}
		dep = 0;
		v[ny][nx] = true;
		go(ny,nx,cnt+1,nd);
		
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
		if(sd%2==1) {
			sd+=2;
			sd%=4;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		v[sy][sx] = true;
		go(sy,sx,1,sd);
		System.out.println(ans);
	}
}
