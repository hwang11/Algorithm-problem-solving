package Algo8;

import java.util.LinkedList;
import java.util.Scanner;

public class B15683 {
	static int n,m,min,ans;
	static int map[][];
	static int copy[][];
	static LinkedList<Dot> li;
	static int dis[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean v[][];
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	public static void back() {
		
	}
	public static int count() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(copy[i][j] == 0) min++;
			}
		}
		return min;
	}
	public static void fill(int y,int x,int n) {
		if(n==1) {

		}
	}
	public static void dfs(int cnt) {
		if(cnt == li.size()) {
			ans=Math.min(ans, count());
			init();
			return;
		}
		for(int i=0;i<li.size();i++) {
			Dot dot = li.get(i);
			switch(map[li.get(i).y][li.get(i).x]) {
			case 1:
				for(int j=0;j<4;i++) {
					if(v[i][j]) continue;
					v[i][j] = true;
					while(true) {
						int ny = dot.y + dis[i][0];
						int nx = dot.x + dis[i][1];
						if(ny < 0 || nx < 0 || ny >= n || nx >= m)continue;
						if(map[ny][nx] == 6) break;
						copy[ny][nx] = -1;
					}
					dfs(cnt+1);
					v[i][j] = false;
				}
				break;
			case 2:
				for(int j=0;j<2;j++) {
					if(v[i][j]) continue;

					
				}
				break;
			case 3:
				for(int j=0;j<4;j++) {
					if(v[i][j]) continue;

				}
				break;
			case 4:
				for(int j=0;j<4;j++) {
					if(v[i][j]) continue;

				}
				break;
			case 5:
				for(int j=0;j<1;j++) {
					if(v[i][j]) continue;

				}
				break;
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		copy = new int[n][m];
		li = new LinkedList<Dot>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>0 && map[i][j]<6) {
					li.add(new Dot(i,j));
				}
			}
		}
		v = new boolean[li.size()][4];
		dfs(0);

	}
	public static class Dot{
		int x;
		int y;
		public Dot(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
