package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
	static int N,M,ret,ans;
	static int map[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static void bfs(int x,int y) {
		v[x][y] = true;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y,1));
		
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			if(dot.x == N-1 && dot.y == M-1) {
				ans = dot.d;
				return;
				
			}
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny]==0) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny,dot.d+1));
				ret++;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String st = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j] = st.charAt(j) - 48;
			}
		}
		bfs(0,0);
		System.out.println(ans);
	}
	public static class Dot{
		int x,y,d;
		public Dot(int x,int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
