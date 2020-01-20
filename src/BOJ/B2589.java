package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2589 {
	static int n,m,ans,cnt;
	static char map[][];
	static boolean v[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static int bfs(int x1,int y1) {
		v[x1][y1] = true;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x1,y1,0));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			cnt = dot.cnt;
			for(int i=0;i<4;i++) {
				int mx = dot.x + dis[i][0];
				int my = dot.y + dis[i][1];
				if(mx < 0 || mx >= n || my < 0 || my >= m) continue;
				if(v[mx][my]) continue;
				if(map[mx][my] == 'W') continue;
				v[mx][my] = true;
				q.add(new Dot(mx,my,dot.cnt+1));
			}
		}
		return cnt;
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
		map = new char[n][m];
		v = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'W') continue;
				init();
				ans=Math.max(ans, bfs(i,j));
			}
		}
		System.out.println(ans);
		
		
	}
	
	static class Dot{
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
