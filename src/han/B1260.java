package han;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	static int N,M,V;
	static int ad[][];
	static boolean vi[];
	static void dfs(int v) {
		vi[v] = true;
		System.out.print(v+" ");
		for(int i=1;i<=N;i++) {
			if(ad[v][i] == 1 && ad[i][v] == 1&& !vi[i]) dfs(i);
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		vi[v] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			for(int i=1;i<=N;i++) { //여기 안에서는 하나의 u를 기준으로 여러번 돌기 때문에 
				if(ad[u][i] == 1 && ad[i][u] == 1&& !vi[i]) {
					q.add(i);
					vi[i] = true;
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		ad = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			ad[v1][v2] = 1;
			ad[v2][v1] = 1;
		}
		vi = new boolean[N+1];
		dfs(V);
		vi = new boolean[N+1];
		System.out.println();
		bfs(V);
		
		
	}
}
