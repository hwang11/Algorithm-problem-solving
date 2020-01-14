package aaa;

import java.util.LinkedList;
import java.util.Scanner;
/*
 * 이 문제는 조합문제라서 순서가 중요치 않다. 따라서 굳이 리스트를 생성하지 않아도 방문한 곳만 확인해도 ok
 * 리스트와 visit이 동일! 
 */
public class B15686 {
	static int N, M, ans, min, cnt;
	static int map[][];
	static boolean v[];
	static LinkedList<Dot> c = new LinkedList<Dot>();
	static LinkedList<Dot> ho = new LinkedList<Dot>();
	static LinkedList<Integer> li = new LinkedList<Integer>(); // 뽑은 치킨집

	static void dfs(int dep, int idx) {
		if (dep == M) {
			// System.out.println("===================");
			// for(int i=0;i<li.size();i++) {
			// System.out.print(li.get(i)+" ");
			// }
			// System.out.println();
			// for(int i=0;i<c.size();i++) {
			// if(v[i]) System.out.print(1+" ");
			// else System.out.print(0+" ");
			// }
			// System.out.println();
			min = Math.min(distan(), min);
		}
		for (int i = idx; i < c.size(); i++) {
			if (v[i])
				continue;
			// li.add(i);
			v[i] = true;
			dfs(dep + 1, i + 1);
			v[i] = false;
			// li.removeLast();
		}
	}

	static int cal(Dot a, Dot b) {
		int d = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
		return d;
	}

	static int distan() {
		int mind = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < ho.size(); i++) {
			Dot house = ho.get(i);
			mind = Integer.MAX_VALUE; // 갱신이 제대로 안되어있어서 틀렸음.
			for (int j = 0; j < c.size(); j++) {
				if (v[j]) {
					Dot chk = c.get(j);
					mind = Math.min(mind, cal(house, chk));
				}
				// System.out.println(mind);
			}
			sum += mind;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					c.add(new Dot(i, j));
				if (map[i][j] == 1)
					ho.add(new Dot(i, j));
			}
		}
		v = new boolean[c.size()];
		dfs(0, 0); // dfs for문으로 여기서 돌리지 않아도 같은 결과.
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
