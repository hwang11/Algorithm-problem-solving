package han;

import java.util.Scanner;

public class B11724 {
	static int N, M;
	static int adj[][];
	static boolean v[];

	static void dfs(int d) {
		v[d] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[d][i] == 1 && adj[i][d] == 1 && !v[i])
				dfs(i);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N + 1];
		adj = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adj[v1][v2] = 1;
			adj[v2][v1] = 1;
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
