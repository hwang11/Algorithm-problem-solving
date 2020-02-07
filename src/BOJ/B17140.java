package BOJ;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B17140 {
	static int R, C, K, t, rmax, cmax;
	static int map[][];
	static int temp[][];
	static int num[];
	static PriorityQueue<Num> pq;

	static void rsort() {
		for (int i = 0; i < map.length; i++) {
			num = new int[101];
			for (int j = 0; j < map[0].length; j++) {
				int d = map[i][j];
				/// System.out.println(d);
				num[d]++;
			}
			for (int j = 1; j <= 100; j++) {
				if (num[j] > 0)
					pq.add(new Num(j, num[j]));
			}
			int size = pq.size();
			cmax = Math.max(cmax, size * 2); // 최대 열
			for (int j = 0; j < size * 2; j += 2) {
				Num num1 = pq.poll();
				int n = num1.n;
				int len = num1.len;
				temp[i][j] = n;
				temp[i][j + 1] = len;
			}
		}
		map = new int[map.length][cmax];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < cmax; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	static void csort() { // 1열씩 정렬
		for (int i = 0; i < map[0].length; i++) {
			num = new int[101];
			for (int j = 0; j < map.length; j++) {
				num[map[j][i]]++;
			}
			for (int j = 1; j <= 100; j++) {
				if (num[j] > 0)
					pq.add(new Num(j, num[j]));
			}
			int size = pq.size();
			rmax = Math.max(rmax, size * 2);
			for (int j = 0; j < size * 2; j += 2) {
				Num num1 = pq.poll();
				int n = num1.n;
				int len = num1.len;
				temp[j][i] = n;
				temp[j + 1][j] = len;
			}
		}
		map = new int[rmax][map[0].length];
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < rmax; j++) {
				map[j][i] = temp[j][i];
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt() - 1;
		C = sc.nextInt() - 1;
		K = sc.nextInt();
		num = new int[101];
		map = new int[3][3];
		temp = new int[101][101];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pq = new PriorityQueue<Num>();
		t = 0;
		int ans = 0;
		while (true) {
			if (t > 100) {
				ans = -1;
				break;
			}
			if (map[R][C] == K)
				break;
			if (map.length >= map[0].length)
				rsort();
			else
				csort();

			t++;
		}
		if (t <= 100)
			ans = t;
		System.out.println(ans);
	}

	public static class Num implements Comparable<Num> {
		int n, len;

		public Num(int n, int len) {
			this.n = n;
			this.len = len;
		}

		@Override
		public int compareTo(Num o) {
			if (o.len == this.len) {
				return o.n > this.n ? 1 : -1;
			}
			return o.len > this.len ? 1 : -1;
		}
	}

}
