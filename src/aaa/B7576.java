package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class B7576 {
	static int M,N,ans,max;
	static Queue<Dot> q;
	static int arr[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean v[][];
			
	static boolean chk() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!v[i][j]&&arr[i][j]==0) return false;
			}
		}
		return true;
	}
 	static void bfs() {
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			v[dot.x][dot.y] = true;
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(v[nx][ny]) continue;
				if(arr[nx][ny] != 0) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny,dot.d+1));
				max = Math.max(max, dot.d+1);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int all = 0;
		v = new boolean[M][N];
		arr = new int[M][N];
		q = new LinkedList<Dot>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) {
					q.add(new Dot(i,j,0)); //동시에 번식하기 위해서 큐에 다 넣어둠 
					all++;
				}
			}
		}
		if(all == N*M) System.out.println(0);
		else {
			bfs();
			if(!chk()) System.out.println(-1);
			else System.out.println(max);
		}
		
	}
	static class Dot{
		int x,y,d;
		public Dot(int x,int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
