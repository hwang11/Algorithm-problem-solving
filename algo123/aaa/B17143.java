package aaa;

import java.util.Scanner;

public class B17143 {
	static int R, C, M, ans, my;
	static sh map[][][];
	static int dr[][] = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // 위 아래 오른 왼

	static void move(int t) {
		for (int i = 1; i <= R; i++) { // 행
			for (int j = 1; j <= C; j++) {
				if (map[i][j][t].z == 0)
					continue;
				sh sh1 = map[i][j][t];
				int ix = i; int iy = j;
				int s = sh1.s; int d = sh1.d;
				int dx = s * dr[d][0]; int dy = s * dr[d][1];
				int mx = i + dx; my = j + dy; int md = sh1.d;
				
				while (mx < 1 || mx > R || my < 1 || my > C) {
					if (mx < 1) { // 위
						dx = Math.abs(dx); int a = ix - 1; dx -= a;
						md = 2; mx = 1 + dx * dr[md][0]; ix = 1;
					} else if (mx > R) { // 아래
						dx = Math.abs(dx); int a = R - ix; dx -= a;
						md = 1; ix = R; mx = R + dx * dr[md][0];
					} else if (my < 1) { // 왼
						int a = iy - 1; dy = Math.abs(dy); dy -= a;
						md = 3; my = 1 + dy * dr[md][1]; iy = 1;
					} else if (my > C) { // 오
						dy = Math.abs(dy); int a = C - iy; dy -= a;
						md = 4; my = C + dy * dr[md][1]; iy = C;
					}
				}
				if (map[mx][my][t + 1].z < sh1.z) 
					map[mx][my][t + 1] = new sh(sh1.s, md, sh1.z);
			}
		}
	}

	static void solve() {
		for (int i = 1; i <= C; i++) { // 시간과 열이 동일함
			boolean flag = false;
			for (int j = 1; j <= R; j++) {
				if (map[j][i][i].z > 0 && !flag) { // 잡아먹음
					ans += map[j][i][i].z;
					map[j][i][i] = new sh(0, 0, 0);
					flag = true;
				}
			}
			if (i < C) move(i);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		ans = 0;

		map = new sh[R + 1][C + 1][C + 1];
		for (int k = 1; k <= C; k++) {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					map[i][j][k] = new sh(0, 0, 0);
				}
			}
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			map[x][y][1] = new sh(s, d, z);
		}
		if (M == 0) {
			System.out.println(0);
		} else {
			solve();
			System.out.println(ans);
		}

	}

	static class sh {
		int s, d, z;

		public sh(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
