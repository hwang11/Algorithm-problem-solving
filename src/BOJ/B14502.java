package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class B14502 {
	static int N,M,ans;
	static int map[][];
	static int copy[][];
	static LinkedList<Dot> li;
	static boolean v1[][],v2[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void cal(int[][] a) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(a[i][j] == 0) cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
	static void fill(int [][]arr) {
		Queue<Dot> q = new LinkedList<Dot>();
		for(int i=0;i<li.size();i++) {
			q.add(li.get(i));
		}
		
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(v2[nx][ny]) continue;
				if(arr[nx][ny] == 1) continue;
				if(arr[nx][ny] == 0) {
					v2[nx][ny] = true;
					arr[nx][ny] = 2;
					q.add(new Dot(nx,ny));
				}
			}
		}
		
	}
	static void print() {
		System.out.println();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void copy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	static void dfs(int cnt) {
		if(cnt == 3) {
			//print();
			copy = new int[N][M];
			copy();
			
			fill(copy);
			
			
			//print();
			cal(copy);
			v2 = new boolean[N][M];
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==1 || map[i][j]==2) continue;
				map[i][j] = 1;
				dfs(cnt+1);
				map[i][j] = 0;
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy = new int[N][M];
		v1 = new boolean[N][M];
		v2 = new boolean[N][M];
		li = new LinkedList<Dot>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) li.add(new Dot(i,j));
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) continue;
				map[i][j] = 1;
				dfs(1);
				map[i][j] = 0;
			}
		}
		
		System.out.println(ans);
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x =x;
			this.y =y;
		}
	}
}
