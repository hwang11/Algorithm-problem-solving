package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class B14500 {
	static int n, m, ans, sum,sum1;
	static int map[][];
	static boolean v[][];
	static int d[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static boolean flag;
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (v[i][j]) {
					System.out.print(1 + " ");
				} else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int x, int y, int cnt) {
		if (cnt == 4) {
			print();
			System.out.println();
			ans = Math.max(sum1, ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx >= n || ny >= m || nx < 0 || ny < 0)
				continue;
			if (v[nx][ny])
				continue;
			v[nx][ny] = true;
			sum1 += map[nx][ny];
			dfs(nx, ny, cnt + 1);
			v[nx][ny] = false;
			sum1 -= map[nx][ny];
		}
	}

	public static void dfs2(int x, int y) {
		for(int k=0;k<4;k++) {
			sum = 0;
			sum = map[x][y];
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				if(i==k) continue;
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				if (nx >= n || ny >= m || nx < 0 || ny < 0)
					continue;
				sum += map[nx][ny];
				cnt++;
			}
			if (cnt == 3) {
				ans = Math.max(sum, ans);
				//return; return하면안되고 모든 경우의 수를 봐야함 
			}
		}
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v[i][j] = true;
				sum1 = map[i][j];
				dfs(i, j, 1);
				sum1 -=map[i][j];
				sum = 0;
				dfs2(i, j);
				v[i][j] = false;
			}
		}
		System.out.println(ans);
	}
}
