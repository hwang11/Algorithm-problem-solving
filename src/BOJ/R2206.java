package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R2206 {
	static int n,m,ans;
	static boolean v[][][];
	static int map[][];
	static int dr[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0,0,0,0));
		v[0][0][0] =  true;
		
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			if(dot.y == n-1 && dot.x == m-1) {
				ans = Math.min(ans, dot.c+1);
				return;
			}
			for(int i=0;i<4;i++) {
				int ny = dot.y + dr[i][0];
				int nx = dot.x + dr[i][1];
				if(ny < 0 || nx < 0 || ny >=n || nx >= m) continue;
				if(map[ny][nx] == 1) {
					if(v[ny][nx][1]) continue;
					if(dot.t<1) {
						v[ny][nx][1] = true;
						q.add(new Dot(ny,nx,dot.c+1,1));
					}
				}
				else {
					if(v[ny][nx][dot.t]) continue;
					v[ny][nx][dot.t] = true;
					q.add(new Dot(ny,nx,dot.c+1,dot.t));
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = new boolean[n][m][2];
		map = new int[n][m];
		String s = sc.nextLine();
		for(int i=0;i<n;i++) {
			s = sc.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
	}
	static class Dot{
		int y;
		int x;
		int c;
		int t;
		public Dot(int y,int x,int c,int t) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.t = t;
		}
	}
}
