package practice26;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//sw expert 1249. 보급로.
public class E1249 {
	static int n;
	static int map[][];
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static int ds[][];
	
	static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx < 0 || mx >= n || my <0 || my >= n) continue;
				if(ds[mx][my] > ds[e.x][e.y] + map[mx][my]) {
					ds[mx][my] = ds[e.x][e.y] + map[mx][my]; 
					q.add(new Dot(mx,my));
				}
			}
		}

	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			n = sc.nextInt();
			map = new int[n][n];
			ds = new int[100][100];
			for(int j=0;j<n;j++) {
				String s = sc.next();
				for(int k=0;k<n;k++) {
					map[j][k] = s.charAt(k) - 48;
					ds[j][k] = Integer.MAX_VALUE;
				}
			}	
			ds[0][0] = 0;
			bfs(0,0);
			System.out.println("#"+(i+1)+" "+ds[n-1][n-1]);
		}
	}
	
	static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
