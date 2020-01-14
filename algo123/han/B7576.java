package han;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {
	static int N,M,max;
	static int map[][];	
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static Queue<Dot> q;
	static boolean v[][];
	static void bfs() {
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny] != 0) continue;
				v[nx][ny] = true;
				map[nx][ny] = 1;
				q.add(new Dot(nx,ny,dot.cnt+1));
				max = Math.max(max, dot.cnt+1);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[M][N];
		map = new int[M][N];
		q = new LinkedList<Dot>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) q.add(new Dot(i,j,0));
			}
		}
		bfs();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) max = -1;
			}
		}
		System.out.println(max);
	}
	static class Dot{
		int x,y,cnt;
		public Dot(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
