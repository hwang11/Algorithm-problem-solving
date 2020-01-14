package aa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17142 {
	static int N,M,cnt,min;
	static int map[][];
	static int chk[][];
	static boolean v[];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static LinkedList<Dot> li = new LinkedList<Dot>();
	static LinkedList<Integer> vl = new LinkedList<Integer>();
	static Queue<Dot> q;
	static void dfs(int dep,int idx) {
		if(dep == M) {
			q = new LinkedList<Dot>();
			chk = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					chk[i][j] = -1;
				}
			}
			for(int i=0;i<vl.size();i++) {
				Dot dot = li.get(vl.get(i));
				chk[dot.x][dot.y] = 0;
				q.add(dot);
			}
			bfs();
		}
		for(int i=idx;i<li.size();i++) {
			if(v[i]) continue;
			v[i] = true;
			vl.add(i);
			dfs(dep+1,i+1);
			v[i] = false;
			vl.removeLast();
		}
	}
	static void bfs() {
		int time=0,vcnt=0;
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(chk[nx][ny] == -1 && map[nx][ny] != 1) {
					chk[nx][ny] = chk[dot.x][dot.y] + 1;
					if(map[nx][ny] == 0) {
						time = Math.max(time, chk[nx][ny]);
						vcnt++;
					}
					q.add(new Dot(nx,ny));
				}
			}
		}
		if(cnt == vcnt && time < min) min = time;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		chk = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] ==2) li.add(new Dot(i,j));
				if(map[i][j]==0) cnt++;
			}
		}
		v = new boolean[li.size()];

		dfs(0,0);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x =x;
			this.y =y;
		}
	}
}
