package BOJ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2583 {
	static int M,N,K;
	static int arr[][];
	static boolean v[][];
	static LinkedList<Integer> li;
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		int cnt2 = 1;
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(arr[nx][ny] ==1 || v[nx][ny]) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny));
				cnt2++;
			}
		}
		li.add(cnt2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		int cnt = 0;
		li = new LinkedList<Integer>();
		arr = new int[M][N];
		v= new boolean[M][N];
		for(int i=0;i<K;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=x1;j<x2;j++) {
				for(int k=y1;k<y2;k++) {
					arr[k][j] = 1;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0 && !v[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(li);
		for(int i=0;i<li.size();i++) {
			System.out.print(li.get(i)+" ");
		}
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
