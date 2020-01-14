package Asamsung;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B16235 {
	static int N, M, K, ans;
	static Dot map[][];
	// (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c),
	// (r+1, c+1)
	static int d[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static LinkedList<Die> die = new LinkedList<Die>();
	static PriorityQueue<Tree>[][] pq;

	public static void solve() {
		int year = 0;
		while (year < K) {
			//System.out.println("year"+year);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!pq[i][j].isEmpty()) {
						int size = pq[i][j].size();
						LinkedList<Tree> tt = new LinkedList<Tree>();
						for (int k = 0; k < size; k++) { // 한 좌표에 있는나무개수 만큼
							Tree tr = pq[i][j].poll();
							if (map[i][j].dg >= tr.age) {
								//System.out.printf("증가 전 %d,%d 나이: %d %d\n", i, j, tr.age, map[i][j].dg);
								tr.g += tr.age;
								map[i][j].dg -= tr.age;
								++tr.age;
								tt.add(tr);
								//if(i==3&&j==1)System.out.printf("증가후  %d,%d 나이: %d %d\n", i, j, tr.age, map[i][j].dg);
							} else { // 죽음
								ans--;
								die.add(new Die(i, j, (tr.age / 2)));
								//System.out.println(i + "," + j + "요기 ");
							}
						}
						size = tt.size();
						for (int l = 0; l < size; l++) {
							pq[i][j].add(tt.get(l));
						}
						tt.clear();
					}
				}
			}
			int dsize = die.size();
			for (int i = 0; i < dsize; i++) {
				Die p = die.get(i);
				map[p.x][p.y].dg += p.u;
			}
			die.clear();
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (pq[i][j].isEmpty())
						continue;
					int size = pq[i][j].size();
					LinkedList<Tree> tt = new LinkedList<Tree>();
					for (int k = 0; k < size; k++) { // 한 좌표에 있는나무개수 만큼
						Tree tr = pq[i][j].poll();
						if (tr.age % 5 == 0) {
							//System.out.printf("5의 배수: %d,%d age:%d\n", i, j, tr.age);
							for (int l = 0; l < 8; l++) {
								int nx = i + d[l][0];
								int ny = j + d[l][1];
								if (ny < 1 || nx < 1 || ny > N || nx > N)
									continue;
								pq[nx][ny].add(new Tree(1, 0));
								ans++;
							}
						}
						tt.add(tr);
					}
					size = tt.size();
					for (int p = 0; p < size; p++) {
						pq[i][j].add(tt.get(p));
					}
				}
			}
			// System.out.printf("%d,%d %d %d\n",i,j,map[i][j].dg,map[i][j].ng);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j].dg += map[i][j].ng; // 겨울
					//if(i==3&&j==1) System.out.println("dg"+map[i][j].dg);
				}
			}
			year++;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new Dot[N + 1][N + 1];
		pq = new PriorityQueue[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int ng = sc.nextInt();
				map[i][j] = new Dot(ng, 5);
				pq[i][j] = new PriorityQueue<Tree>();
			}
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			pq[x][y].add(new Tree(age, 0));
			ans++;
		}
		solve();
		System.out.println(ans);
	}

	public static class Die {
		int x;
		int y;
		int u;

		public Die(int x, int y, int u) {
			this.x = x;
			this.y = y;
			this.u = u;

		}
	}

	static class Tree implements Comparable<Tree> {
		int age;
		int g; // 나무가 섭취한 양분

		public Tree(int age, int g) {
			this.age = age;
			this.g = g;
		}

		@Override
		public int compareTo(Tree tr) {
			return this.age >= tr.age ? 1 : -1;
		}
	}

	static class Dot {
		int ng; // 겨울마다공급되는 양분
		int dg; // 땅에 있는 양분

		public Dot(int ng, int dg) {
			this.ng = ng;
			this.dg = dg;
		}
	}

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
