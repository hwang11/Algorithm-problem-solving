package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {
	static int n;
	static int m;
	static int map[][];
	static int tempmap[][];
	static int copymap[][];
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean v[][];
	static int ans;
	
	
	public static void calc() {
		int cnt2 = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(copymap[i][j] == 0) {
					
					cnt2++;
				}
			}
		}
		if(cnt2 > ans) {
			ans = cnt2;
		}
	}
	
	public static void dfs(int x,int y,int cnt) {
		if(cnt == 3) {
			copymap = new int[n+1][m+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					copymap[i][j] = tempmap[i][j];
				}
			}
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(copymap[i][j] == 2) spread(i,j);
				}
			}
			calc();
		}
		else {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(tempmap[i][j] == 0) {
						tempmap[i][j] = 1;
						dfs(i,j,cnt+1);
					}
				}
			}
		}
		--cnt;
		tempmap[x][y] = 0;
		
	}
	
	public static void spread(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx>n || mx<1 || my >m || my < 1) continue;
				if(copymap[mx][my] == 1) continue; 
				else if(!v[mx][my] && copymap[mx][my] == 0) {
					q.add(new Dot(mx,my)); 
					copymap[mx][my] = 2;
					v[mx][my] = true;
				}
			}
		}
	}
	public static void init() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				v[i][j] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		tempmap = new int[n+1][m+1];
		v = new boolean[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				tempmap[i][j] = map[i][j] = sc.nextInt();
			}
		}
		
		init();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(tempmap[i][j] == 0) {
					tempmap[i][j] = 1;
					dfs(i,j,1);
					tempmap[i][j] = 0;
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
