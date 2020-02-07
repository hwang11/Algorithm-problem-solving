package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs {
	static int N, M, V;
	static boolean v[];
	static int adj[][];

	static void dfs(int d) {
		v[d] = true;
		System.out.print(d + " ");
		for (int i = 1; i <= N; i++) {
			if (!v[i] && adj[d][i] == 1 && adj[i][d] == 1)
				dfs(i);
		}
	}

	static void bfs(int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(d);
		v[d] = true;
		while (!q.isEmpty()) {
			int s = q.poll();
			System.out.print(s + " ");
			for (int i = 1; i <= N; i++) {
				if (!v[i] && adj[d][i] == 1 && adj[i][d] == 1) {
					v[i] = true;
					q.add(i);
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new int[N + 1][N + 1];
		M = sc.nextInt();
		V = sc.nextInt();
		v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adj[v1][v2] = 1;
			adj[v2][v1] = 1;
		}
		dfs(V);
		v = new boolean[N + 1];
		bfs(V);

	}
}
