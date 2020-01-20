package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	static int N,M,V;
	static int map[][];
	static boolean v[];
	static void dfs(int s) {
		v[s] = true;
		System.out.print(s+" ");
		for(int i=1;i<=N;i++) {
			if(v[i]) continue;
			if(map[s][i] == 1 && map[i][s] == 1) {
				dfs(i);
			}
		}
	}
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		v[s] = true;
		q.add(s);
		while(!q.isEmpty()) {
			int d = q.poll();
			System.out.print(d+" ");
			for(int i=1;i<=N;i++) {
				if(v[i]) continue;
				if(map[s][i] == 1 && map[i][s] == 1) {
					q.add(i);
					v[i] = true;
				}
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}
		dfs(V);
		System.out.println();
		v = new boolean[N+1];
		bfs(V);
	}
}
