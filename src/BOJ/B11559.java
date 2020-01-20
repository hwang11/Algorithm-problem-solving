package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//false이면 for문을 이어가야하고 ,true이면 for문 첨부터시작.
public class B11559 {
	static char map[][];
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean v[][];
	static int cnt, ans;
	static boolean flag;
	static LinkedList<Dot> li;

	public static void down() {
		int maxX, maxY, minX, minY;
		maxX = maxY = 0;
		minX = minY = Integer.MAX_VALUE;
		int high, width = 0;
		for (int i = 0; i < 4; i++) {
			int x = li.get(i).x;
			int y = li.get(i).y;
			maxX = Math.max(maxX, x);
			minX = Math.min(minX, x);
			maxY = Math.max(maxY, y);
			minY = Math.min(minY, y);
		}
		high = Math.abs(maxX - minX);
		width = Math.abs(maxY - minY);
		for (int j = 0; j < width + 1; j++) {
			int x = li.get(j).x;
			int y = li.get(j).y;
			for (int i = 0; i < high + 1; i++) {
				for (int k = 11; k > 0; k--) {
					map[k][y] = map[k - 1][y];
					// System.out.println();
					// System.out.println("i: "+i+ "map["+k+"]["+y+"] map["+(k-1)+"]["+y+"]");
					// print();
				}
			}
			//
			// print();
		}
	}

	public static void print() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int mx = x + dir[i][0];
			int my = y + dir[i][1];
			if (mx < 0 || mx > 11 || my < 0 || my > 5)
				continue;
			if (v[mx][my])
				continue;
			if (map[x][y] == map[mx][my]) {
				v[mx][my] = true;
				li.add(new Dot(mx, my));
				dfs(mx,my);
			}
		}
	}

	public static void init() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				v[i][j] = false;
			}
		}
	}

	public static void solve() {
		while (true) {
			flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						li.clear();
						init();
						li.add(new Dot(i,j));
						dfs(i, j);
						if (li.size() >= 4) {
							flag = true;
							ans++;
							down();
						}
					}
				}
			}
			if (flag == false) {
				break;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		li = new LinkedList<Dot>();
		v = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve();
		System.out.println(ans);
	}

	public static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
