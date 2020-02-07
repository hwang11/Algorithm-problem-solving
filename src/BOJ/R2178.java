package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R2178 {
	static int n,m,cnt;
	static int a[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean v[][];
	
	public static  void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0,0,1));
		v[0][0] = true;
		while(!q.isEmpty()) {
			Dot d = q.poll();
			if(d.x == n-1 && d.y == m-1) {
				System.out.println(d.cnt); 
			}
			for(int j=0;j<4;j++) {
				int mx = d.x + dis[j][0];
				int my = d.y + dis[j][1];
				if(mx < 0 || mx >=n||my<0 || my >=m) continue;
				if(a[mx][my] == 0) continue;
				if(v[mx][my]) continue;
				v[mx][my] = true;
				q.add(new Dot(mx,my,d.cnt+1));
			}
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		v = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String st = sc.next();
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.charAt(j)+"");
				v[i][j] = false;
			}
		}
		bfs();
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
