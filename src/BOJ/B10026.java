package Algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10026 {
	static int n;
	static char map[][];
	static char map2[][];
	static boolean flag;
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void bfs(int x,int y,char map[][],boolean flag) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		char c = map[x][y];
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int mx = dot.x + dis[i][0];
				int my = dot.y + dis[i][1];
				if(mx >= n || mx <0 || my < 0 || my>=n) continue;
				if(flag) {
					if(c == 'G' || c == 'R') {
						if(map[mx][my]=='0' || map[mx][my] == 'B') continue;
					}
					else {
						if(map[mx][my]!=c) continue;
					}
				}
				else {
					if(map[mx][my]!=c) continue;
				}
				map[mx][my] = '0';
				q.add(new Dot(mx,my));
			}
		}
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		map2 = new char[n][n];
		flag = false;
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<n;j++) {
				map2[i][j]=map[i][j] = s.charAt(j);
			}
		}
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!='0') {
					bfs(i,j,map,flag);
					cnt++;
				}
			}
		}
		flag = true;
		System.out.println(cnt);

		cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map2[i][j]!='0') {
					bfs(i,j,map2,flag);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
