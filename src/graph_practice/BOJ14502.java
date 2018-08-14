package graph_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {
	static int n;
	static int m;
	static int map[][];
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean v[][];
	public static void spread(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx>n || mx<0 || my > m || my < 0) continue;
				//System.out.println("mx,my:"+mx+","+my);
				if(v[mx][my] == false && map[mx][my] == 0) {
					System.out.println("가능한 mx,my:"+mx+","+my);
					q.add(new Dot(mx,my)); 
					map[mx][my] = 2;
					v[mx][my] = true;
				}
			}
		}
	}
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				v[i][j] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		v = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		init();
		spread(1,5);
		System.out.println("답:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
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
