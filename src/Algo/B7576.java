package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {
	static int m;
	static int n;
	static int cnt;
	static int a[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue q = new LinkedList<Dot>();
	public static int bfs() {
		while(!q.isEmpty()) {
			Dot d = (Dot) q.poll();
			for(int i=0;i<4;i++) {
				int mx = d.x + dis[i][0];
				int my = d.y + dis[i][1];
				if(mx < 0 || mx >= n || my < 0 || my >= m) continue;
				if(a[mx][my] != 0) continue;
				a[mx][my] = a[d.x][d.y]+1;//익음.
				q.add(new Dot(mx,my));
				
			}
		}
		
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j] == 0) {
					return -1;
				}
				else {
					max = Math.max(max, a[i][j]);
				}
			}
		}
		return (max-1);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		a = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]==1) {
					q.add(new Dot(i,j));
				}
			}
		}
		int result = bfs();
		if(result==-1) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
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
