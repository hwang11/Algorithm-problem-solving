package BOJ;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BB16236 {
	static boolean flag;
	static int N, size, ans, x, y, cnt;
	static int a[][];
	static boolean v[][];
	static int dr[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }; // 상좌우하

	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		PriorityQueue<Dot> pq = new PriorityQueue<Dot>();
		q.add(new Dot(x, y, 0));
		v[x][y] = true;
		int nx = 0, ny = 0,f=0;
		while (true) {
			f = -1;
			while (!q.isEmpty()) {
				Dot dot = q.poll();
				for (int i = 0; i < 4; i++) {
					nx = dot.x + dr[i][0];
					ny = dot.y + dr[i][1];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (v[nx][ny])
						continue; // 헷갈림
					if (a[nx][ny] > size)
						continue;
					if (a[nx][ny] < size && a[nx][ny] > 0) {
						System.out.printf("상어이동좌표 %d,%d 거리:%d 크기:%d\n", nx, ny, (dot.t + 1), a[nx][ny]);
						f = (dot.t+1);
						pq.add(new Dot(nx, ny, dot.t + 1));
						break;
					}
					v[nx][ny] = true;
					q.add(new Dot(nx, ny, dot.t + 1));
				}
			}
			if (f==-1) {
				break;
			} else {
				Dot item = pq.poll();
				cnt++; // 먹기
				a[x][y] = 0;
				a[item.x][item.y] = 9;
				ans += f;
				x = item.x;
				y = item.y;
				if (cnt == size) {
					cnt = 0;
					size++;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		v = new boolean[N][N];
		a = new int[N][N];
		size = 2;
		x = 0;
		y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}
		cnt = 0;
		bfs();
		System.out.println(ans);
	}

	static class Dot implements Comparable<Dot> {
		int x, y, t;

		public Dot(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public int compareTo(Dot d) {
			if (this.x < d.x) {
				return -1;
			} else if (this.x == d.x) {
				if (this.y < d.y) {
					return -1;
				} else if (this.y == d.y) {
					return 0;
				}
				return 1;
			} else {
				return 1;
			}
		}

	}
}
