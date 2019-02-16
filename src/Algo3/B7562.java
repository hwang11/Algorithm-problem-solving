package Algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7562 {
	static int dis[][] = {{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1}};
	static int n,x1,x2,y1,y2,cnt;
	static int map[][];
	static boolean v[][];
	public static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y,0));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot dot = q.poll(); 
			if(dot.x == x2 && dot.y == y2) {
				System.out.println(dot.cnt);
				return;
			}
			for(int i=0;i<8;i++) {
				int mx = dot.x + dis[i][0];
				int my = dot.y + dis[i][1];
				if(mx >= n || mx < 0 || my >=n || my <0) continue;
				if(v[mx][my]) continue;
				v[mx][my] = true;
				q.add(new Dot(mx,my,dot.cnt+1));
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			n = sc.nextInt();
			map = new int[n][n];
			v = new boolean[n][n];
			
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			bfs(x1,y1);
			
			
		}
	}
	public static class Dot{
		int x;
		int y;
		int cnt;
		public Dot(int x,int y,int c) {
			this.x = x;
			this.y = y;
			this.cnt = c;
		}
	}
}
