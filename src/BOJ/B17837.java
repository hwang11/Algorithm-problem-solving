package BOJ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B17837 {
	static int N, K;
	static point arr[][];
	static player p[];
	static int dr[][] = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 우 좌 상 하
	static int change(int d) {
		int nd = d;
		if(d==1) nd = 2;
		if(d==2) nd = 1;
		if(d==3) nd = 4;
		if(d==4) nd = 3;
		return nd;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new point[N+1][N+1];
		p = new player[K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int c = sc.nextInt();
				arr[i][j] = new point(c,new LinkedList<Integer>());
			}
		}
		int cnt = 0;
		for(int i=1;i<=K;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			p[i] = new player(x,y,d);
			arr[x][y].li.add(i);
		}
		boolean flag = false;
		while(true) {
			cnt++;
			if(cnt>1000) {
				break;
			}
			for(int i=1;i<=K;i++) {
				int d = p[i].d;
				int x = p[i].x;
				int y = p[i].y;
				int num = arr[x][y].li.indexOf(i);
				List<Integer> nli = new LinkedList<Integer>();
				for(int k=num;k<arr[x][y].li.size();k++) {
					nli.add(arr[x][y].li.get(k));
				}
				int nx = x + dr[d][0];
				int ny = y + dr[d][1];
				int nd = d;
				if(nx < 1 || ny < 1 || nx > N || ny > N) { // map 초과 
					nd = change(d);
					nx = x + dr[nd][0]; //한번 더 이동시도 
					ny = y + dr[nd][1];
					if(nx < 1 || ny < 1 || nx > N || ny > N) {
						p[i].d = nd;
						continue;
					}
					if(arr[nx][ny].color==2) {
						p[i].d = nd;
						continue;
					}
				}
				if(arr[nx][ny].color == 2) { //파란색 
					nd = change(d); //방향 바꾸고 
					nx = x + dr[nd][0]; //한번 더 이동시도 
					ny = y + dr[nd][1];
					if(nx < 1 || ny < 1 || nx > N || ny > N) {
						p[i].d = nd;
						continue;
					}
					if(arr[nx][ny].color==2) {
						p[i].d = nd;
						continue;
					}
				}
				if(arr[nx][ny].color == 1) { //list 뒤집기. 빨간색 
					Collections.reverse(nli);
				}
				
				arr[nx][ny].li.addAll(nli); // list 이동 
				for(int k=0;k<nli.size();k++) {
					int idx = nli.get(k);
					p[idx].x = nx;
					p[idx].y = ny;
					//방향은 수정할 필요없음 
					arr[x][y].li.removeLast(); //원래 좌표에서 리스트 삭제 
				}
				if(arr[nx][ny].li.size() >= 4) {
					flag = true;
					break;
				}
				p[i] = new player(nx,ny,nd);
			}
			if(flag) break;
		}
		cnt = cnt>1000 ? -1 : cnt;
		System.out.println(cnt);
	}

	static class player {
		int x, y, d;

		public player(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static class point {
		int color;
		LinkedList<Integer> li;

		public point(int c, LinkedList<Integer> li) {
			this.color = c;
			this.li = li;
		}
	}
}
