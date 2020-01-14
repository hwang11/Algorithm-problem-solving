package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17142 {
	static int N, M, max, min, cnt, vcnt, total;
	static int map[][];
	static int u[][];
	static boolean v[];
	static int dr[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static LinkedList<Dot> li = new LinkedList<Dot>();
	static Queue<Dot> q;

	static void dfs(int dep, int idx) {
		if (dep == M) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					u[i][j] = -1;
				}
			}
			q = new LinkedList<Dot>();
			for (int i = 0; i < li.size(); i++) {
				if (v[i]) {
					Dot dot = li.get(i);
					int x = dot.x;
					int y = dot.y;
					u[x][y] = 0;
					q.add(dot);
				}
			}
			bfs();
		}
		for (int i = idx; i < li.size(); i++) {
			if (v[i])
				continue;
			v[i] = true;
			dfs(dep + 1, i + 1);
			v[i] = false;
		}
	}

	static void bfs() {
		vcnt = 0;
		int time = 0;
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (map[nx][ny] != 1 && u[nx][ny] == -1) {
					u[nx][ny] = u[dot.x][dot.y] + 1;
					if (map[nx][ny] == 0) {
						vcnt++;
						time = u[nx][ny];
					}
					q.add(new Dot(nx, ny));
				}
			}
		}
		if (vcnt == cnt && min > time)
			min = time;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		u = new int[N][N];
		min = Integer.MAX_VALUE;
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					li.add(new Dot(i, j));
				if (map[i][j] == 0)
					cnt++;
			}
		}
		v = new boolean[li.size()];
		dfs(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
