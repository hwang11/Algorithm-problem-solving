package Algo8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R13460 {
	static char map[][];
	static int n, m, fx, fy, cnt, ans;
	static int v[][][][];
	static int rx, ry, bx, by;
	static int nrx, nry, nbx, nby;
	static int orx, ory, obx, oby;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(rx, ry, bx, by));
		while (!q.isEmpty()) {
			int qsize = q.size();
			while (qsize > 0) {
				Dot dot = q.poll();
				orx = dot.rx;
				ory = dot.ry;
				obx = dot.bx;
				oby = dot.by;
				System.out.printf("큐에서 꺼낸거 %d %d & %d %d %d\n",orx,ory,obx,oby,cnt);
				if (orx == fx && ory == fy) { //빨간구슬이 구멍에들어가고 파란구슬은 안들어간 경우 
					if (obx != fx || oby != fy) {
						ans = cnt;
						return;
					}
				}
				for (int i = 0; i < 4; i++) {
					//System.out.printf("i: %d cnt: %d\n",i,cnt);
					
					rx = orx;
					ry = ory;
					bx = obx;
					by = oby;
					while (true) {
						nrx = rx + dx[i];
						nry = ry + dy[i];
						if (map[nrx][nry] == '#')
							break;
						if (rx == fx && ry == fy) {
							break;
						}

						rx = nrx;
						ry = nry;

					}
					while (true) {
						nbx = bx + dx[i];
						nby = by + dy[i];
						if (map[nbx][nby] == '#')
							break;
						if (bx == fx && by == fy) {
							System.out.println("d여기 ");
							break;

						}
						bx = nbx;
						by = nby;
					}
					System.out.printf("돌때 마다 %d %d & %d %d\n",rx,ry,bx,by);
					if (rx == bx && ry == by) { //파란구슬과 빨간구슬이 겹쳤을 경우 어떤게 더 앞서 있는지에 따라서 구슬한칸씩 옮겨주기 
						if (bx == fx && by == fy)
							continue; //q에 추가를 안하고 컨티뉴해서 큐가 그냥 끝나느건가 
						//System.out.printf("%d %d %d %d\n",Math.abs(orx - rx), Math.abs(ory - ry),Math.abs(obx - bx),Math.abs(oby - by));
						if (Math.abs(orx - rx) + Math.abs(ory - ry) > Math.abs(obx - bx) + Math.abs(oby - by)) {
							//절대값이 크다는건 그 전에 더 뒤에 있었다는 얘기이므로 한칸 더 뒤로 옮겨주는 것 
							//System.out.printf("빨간 구슬 이동 전 %d %d\n",rx,ry);
							rx -= dx[i];
							ry -= dy[i];
							//System.out.printf("빨간 구슬 이동 후 %d %d\n",rx,ry);
						} else {
							//System.out.printf("파란 구슬 이동 전 %d %d\n",bx,by);
							bx -= dx[i];
							by -= dy[i];
							//System.out.printf("파란 구슬 이동 후 %d %d\n",bx,by);
						}
						//System.out.println();
					}
					if (v[rx][ry][bx][by] == 1)
						continue;
					v[rx][ry][bx][by] = 1;
					q.add(new Dot(rx, ry, bx, by));

				}
				qsize--;
			}
			if (cnt == 10) {
				ans = -1;
				return;
			}
			cnt++;
		}
		System.out.println(bx+","+by);
		System.out.println(rx+","+ry);
		ans = -1; // 큐가 먼저 끝나는 경우
		return;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[12][12];
		v = new int[12][12][12][12];
		int srx, sry, sbx, sby;
		srx = sry = sbx = sby = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				char item = map[i][j] = s.charAt(j);
				switch (item) {
				case 'O':
					fy = j;
					fx = i;
					break;
				case 'B':
					by = j;
					bx = i;
					map[i][j] = '.';
					break;
				case 'R':
					ry = j;
					rx = i;
					map[i][j] = '.';
					break;
				default:
					break;

				}
			}
		}
		v[srx][sry][sbx][sby] = 1;
		bfs();
		System.out.println(ans);
	}

	public static class Dot {
		int rx;
		int ry;
		int bx;
		int by;

		public Dot(int rx, int ry, int bx, int by) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
}
