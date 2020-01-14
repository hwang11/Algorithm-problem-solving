package Algo8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B15683 {
	static int n, m, min, ans;
	static int map[][][];
	static int cur[][][];
	static LinkedList<Dot> li;
	static int dis1[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우
	static int dis2[][][] = { { { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 0, 1 } } };
	static int dis3[][][] = { { { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } },
			{ { -1, 0 }, { 0, -1 } } }; // 상우 / 하우 / 하좌/ 상좌
	static int dis4[][][] = { { { -1, 0 }, { 1, 0 }, { 0, 1 } }, { { -1, 0 }, { 0, -1 }, { 0, 1 } },
			{ { 1, 0 }, { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 }, { 0, -1 } } };
	static int dis5[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean v1[];
	static boolean v2[][];

	public static void remem(int cnt) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cur[cnt][i][j] = map[0][i][j];
			}
		}
	}
	public static void print() {
		//System.out.println("print합니다.");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[0][i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void back(int cnt) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[0][i][j] = cur[cnt][i][j];
			}
		}
	}

	public static int count() {
		min = 0;
		//System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[0][i][j] == 0) min++;
				//System.out.print(map[0][i][j]+" ");
			}
			//System.out.println();
		}
		//System.out.println("min: "+min);
		return min;
	}


	public static void dfs(int cnt) {
		if (cnt == li.size()) {
			ans = Math.min(ans, count());
			
			return;
		}
		for (int i = 0; i < li.size(); i++) {
			Dot dot = li.get(i);
			if (v1[i])
				continue;
			switch (map[0][li.get(i).y][li.get(i).x]) {
			case 1:
				for (int j = 0; j < 4; j++) {
					if (v2[i][j])
						continue;
					v1[i] = true;
					v2[i][j] = true;
					remem(cnt);
					Queue<Dot> q = new LinkedList<Dot>();
					q.add(new Dot(dot.y,dot.x));
					while(!q.isEmpty()) {
						Dot p = q.poll(); 
						int ny = p.y + dis1[j][0];
						int nx = p.x + dis1[j][1];
						if (ny < 0 || nx < 0 || ny >= n || nx >= m)
							break;
						if (map[0][ny][nx] == 6)
							break;
						//System.out.printf("비춘다 ny : %d, nx %d\n",ny,nx);
						map[0][ny][nx] = 7; // cctv가 비추는 부분
						q.add(new Dot(ny,nx));
					}
					
					dfs(cnt+1);
					v2[i][j] = false;
					back(cnt);

					//print(map);
				}
				break;
			case 2:
				for (int j = 0; j < 2; j++) { //방향 개수 만큼 
					if (v2[i][j])
						continue;
					v1[i] = true;
					v2[i][j] = true;
					remem(cnt);

					//System.out.println("2를 칠하기 전 ");
					//print();
					for (int k = 0; k < 2; k++) {
						Queue<Dot> q = new LinkedList<Dot>();
						q.add(new Dot(dot.y,dot.x));
						while(!q.isEmpty()) {
							Dot p = q.poll();
							int ny = p.y + dis2[j][k][0];
							int nx = p.x + dis2[j][k][1];
							if (ny < 0 || nx < 0 || ny >= n || nx >= m)
								break;
							if (map[0][ny][nx] == 6)
								break;
							map[0][ny][nx] = 7; // cctv가 비추는 부분
							q.add(new Dot(ny,nx));
						}
					}
					dfs(cnt+1);
					v2[i][j] = false;
					back(cnt);
					//System.out.printf("되돌아갑니다 %d\n",cnt);
					//print();
				}

				break;
			case 3:
				for (int j = 0; j < 4; j++) {
					if (v2[i][j])
						continue;
					v1[i] = true;
					v2[i][j] = true;
					remem(cnt);

					// 상우 / 하우 / 하좌/ 상좌
					
					for (int k = 0; k < 2; k++) {
						Queue<Dot> q = new LinkedList<Dot>();
						q.add(new Dot(dot.y,dot.x));
						while(!q.isEmpty()) {
							Dot p = q.poll();
							int ny = p.y + dis3[j][k][0];
							int nx = p.x + dis3[j][k][1];
							if (ny < 0 || nx < 0 || ny >= n || nx >= m)
								break;
							if (map[0][ny][nx] == 6)
								break;
							map[0][ny][nx] = 7; // cctv가 비추는 부분
							q.add(new Dot(ny,nx));
						}
					}
					dfs(cnt+1);
					v2[i][j] = false;
					back(cnt);


				}
				break;
			case 4:
				for (int j = 0; j < 4; j++) {
					if (v2[i][j])
						continue;
					v1[i] = true;
					v2[i][j] = true;
					remem(cnt);

					for (int k = 0; k < 3; k++) {
						Queue<Dot> q = new LinkedList<Dot>();
						q.add(new Dot(dot.y,dot.x));
						while(!q.isEmpty()) {
							Dot p = q.poll();

							int ny = p.y + dis4[j][k][0];
							int nx = p.x + dis4[j][k][1];
							if (ny < 0 || nx < 0 || ny >= n || nx >= m)
								break;
							if (map[0][ny][nx] == 6)
								break;
							map[0][ny][nx] = 7; // cctv가 비추는 부분
							q.add(new Dot(ny,nx));
						}
					}
					dfs(cnt+1);
					v2[i][j] = false;
					back(cnt);

				}
				break;
			case 5:
				for (int j = 0; j < 1; j++) {
					if (v2[i][j])
						continue;
					v1[i] = true;
					v2[i][j] = true;
					remem(cnt);
					//System.out.println("5를 칠하기 전 ");
					//print();
					for (int k = 0; k < 4; k++) {
						Queue<Dot> q = new LinkedList<Dot>();
						q.add(new Dot(dot.y,dot.x));
						while(!q.isEmpty()) {
							Dot p = q.poll();

							int ny = p.y + dis5[k][0];
							int nx = p.x + dis5[k][1];
							if (ny < 0 || nx < 0 || ny >= n || nx >= m)
								break;
							if (map[0][ny][nx] == 6)
								break;
							map[0][ny][nx] = 7; // cctv가 비추는 부분
							q.add(new Dot(ny,nx));
						}
					}
					dfs(cnt+1);
					v2[i][j] = false;
					//System.out.printf("되돌아갑니다 %d\n",cnt);
					back(cnt);
					//print();

				}
				break;
			}
//			dfs(cnt+1);
//			back();
			v1[i] = false;
			
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[1][n][m];
		
		li = new LinkedList<Dot>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[0][i][j] = sc.nextInt();
				if (map[0][i][j] > 0 && map[0][i][j] < 6) { // cctv의 위치를 리스트에 저장
					li.add(new Dot(i, j));
				}
			}
		}
		cur = new int[li.size()][n][m];
		v1 = new boolean[li.size()];
		v2 = new boolean[li.size()][4];
		ans = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(ans);
	}

	public static class Dot {
		int x;
		int y;

		public Dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
