package Algo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2468 {
	static int n;
	static int a[][];
	static int copy[][];
	static boolean v[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				copy[i][j] = a[i][j];
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = false;
			}
		}
	}
	public static void draw(int k) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(copy[i][j] < k) {
					copy[i][j] = 0;
				}
			}
		}
	}
	public static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot d = q.poll();
			for(int i=0;i<4;i++) {
				int mx = d.x + dis[i][0];
				int my = d.y + dis[i][1];
				if(mx < 0 || mx >= n || my < 0 || my >= n) continue;
				if(v[mx][my]) continue;
				if(copy[mx][my] == 0) continue;
				v[mx][my] = true;
				copy[mx][my] = 0;
				q.add(new Dot(mx,my));
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		copy = new int[n][n];
		v = new boolean[n][n];
		int max = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = copy[i][j] = sc.nextInt();
				if(max < a[i][j]) {
					max = a[i][j];
				}
			}
		}
		
		int max2 = 0;
		for(int i=0;i<=max;i++) {
			draw(i);
			int cnt = 0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(copy[j][k] != 0) {
						cnt++;
						bfs(j,k);
					}
				}
			}
			if(max2 < cnt) {
				max2 = cnt;
			}
			init();
		}
		System.out.println(max2);
		
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
