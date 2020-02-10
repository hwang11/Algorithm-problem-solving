package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//틀린코드 
public class B17822 {
	static int N, M, T, ans;
	static boolean v[][];
	static LinkedList<Integer> arr[];
	static int dr[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static int bfs(int x1, int y1, int num) {
		int cnt = 0;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x1, y1));
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			cnt++;
			int x = dot.x;
			int y = dot.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i][0];
				int ny = (y + dr[i][1]) % M;
				if (ny < 0)
					ny = M - 1;
				if (nx < 1 || nx > N || ny < 0 || ny >= M) 
					continue;
				if (num == arr[nx].get(ny)) {
					//System.out.printf("%d %d -> %d %d\n",x,y,nx,ny);
					arr[nx].set(ny, 0);
					q.add(new Dot(nx, ny));
				}
			}
		}
		return cnt;
	}

	static void avg() {
		double sum = 0;
		double cnt2 = 0;
		for (int i = 1; i <= N; i++) { 
			for (int j = 0; j < M; j++) {
				if (arr[i].get(j) > 0) {
					sum += arr[i].get(j);
					cnt2++;
				}
			}
		}
		double avg = sum / cnt2;
		for (int i = 1; i <= N; i++) { 
			for (int j = 0; j < M; j++) {
				if (arr[i].get(j) > 0) {
					double v = arr[i].get(j);
					if (v > avg)
						arr[i].set(j, (int) (v - 1));
					else if (v < avg)
						arr[i].set(j, (int) (v + 1));
				}
			}
		}

	}

	static void rotate(int x, int d, int k) {
		while (x <= N) {
			if (d == 0) {
				for (int i = 0; i < k; i++) {
					arr[x].addFirst(arr[x].removeLast());
				}
			} else {
				for (int i = 0; i < k; i++) {
					arr[x].add(arr[x].removeFirst());
				}
			}
			x += x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		arr = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new LinkedList<Integer>();
			for (int j = 0; j < M; j++) {
				int n = sc.nextInt();
				arr[i].add(n);
			}
		}

		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			rotate(x, d, k);
			boolean flag = false;
			for (int p = 1; p <= N; p++) { 
				for (int j = 0; j < M; j++) {
					if (arr[p].get(j)==0)
						continue;
					if (bfs(p, j, arr[p].get(j)) > 1) {
						flag = true;
					}
				}
			}
			if (!flag) avg();
		}
		for (int i = 1; i <= N; i++) { 
			for (int j = 0; j < M; j++) {
				ans += arr[i].get(j);
			}
		}
		System.out.println(ans);
	}

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
