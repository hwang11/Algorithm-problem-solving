package aaa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2583 {
	static int N,M,K,cnt,ret;
	static LinkedList<Integer> li;
	static int arr[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static void bfs(int x,int y) {
		v[x][y] = true;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(arr[nx][ny] == 1) continue;
				if(v[nx][ny]) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny));
				ret++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[M][N];
		v = new boolean[M][N];
		li = new LinkedList<Integer>();
		
		for(int i=0;i<K;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=y1;j<y2;j++) {
				for(int o=x1;o<x2;o++) {
					arr[j][o] = 1;
				}
			}
		}
		for(int j=0;j<M;j++) {
			for(int o=0;o<N;o++) {
				if(v[j][o]) continue;
				if(arr[j][o] == 1) continue;
				ret = 1;
				bfs(j,o);
				li.add(ret);
				cnt++;
			}
		}
		int a[] = new int[cnt];
		for(int i=0;i<cnt;i++) {
			a[i] = li.get(i);
		}
		Arrays.sort(a);
		System.out.println(cnt);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	public static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
			
		}
	}
}
