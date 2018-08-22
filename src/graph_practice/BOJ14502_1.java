package graph_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502_1 {
	static int n,m,ans;
	static int map[][], temp[][], copy[][];
	static boolean v[][], v2[][];
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx > n || mx < 1 || my > m || my < 1) continue;
				else if(copy[mx][my] == 0) {
					q.add(new Dot(mx,my));
					copy[mx][my] = 2;
				}
			}
		}
	}
	
	public static void dfs(int x,int y,int cnt) {
		if(cnt == 3) {
			copy = new int[n+1][m+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					copy[i][j] = temp[i][j];
				}
			}
			for(int i=1;i<=n;i++) { //바이러스뿌리기.
				for(int j=1;j<=m;j++) {
					if(copy[i][j] == 2) {
						bfs(i,j);
					}
				}
			}
			calc();
		}
		else {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(temp[i][j] == 0) {
						temp[i][j] = 1;
						dfs(i,j,cnt+1);
						temp[i][j] = 0;
					}
					
				}
			}
			
		}
		temp[x][y] = 0;
	}
	public static void calc() {
		int cnt2 = 0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(copy[i][j] == 0) {
					cnt2++;
				}
			}
		}
		if(cnt2>ans) {
			ans = cnt2;
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		temp = new int [n+1][m+1];
		map = new int [n+1][m+1];
		//copy = new int [m+1][n+1];
		
		v = new boolean [n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				temp[i][j] = map[i][j] = sc.nextInt();
				v[i][j] = false;
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(temp[i][j] == 0) {
					temp[i][j] = 1;
					dfs(i,j,1);
					temp[i][j] = 0;
				}
				
			}
		}
		
		
		System.out.println(ans);
		
	}
	
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
