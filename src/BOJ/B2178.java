package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
	static int n,m,cnt;
	static int a[][];
	static boolean v[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0,0));
		v[0][0] = true;
		while(!q.isEmpty()) {
			cnt++;
			int qsize = q.size(); //왜 Q size만큼 도는지? 
			for(int j=0;j<qsize;j++) {
				Dot d = q.poll();
				if(d.x == n-1 && d.y == m-1) {
					System.out.println(cnt);
				}
				for(int i=0;i<4;i++) {
					int mx = d.x + dis[i][0];
					int my = d.y + dis[i][1];
					if(mx<0 || mx>=n || my<0 || my >=m) continue;
					if(a[mx][my] == 0) continue;
					if(v[mx][my]) continue;
					v[mx][my] = true;
					q.add(new Dot(mx,my));
				}
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
			String s = sc.next();
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(s.charAt(j) + "");
				v[i][j] = false;
			}
		}
		cnt = 0;
		bfs();
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
