package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B1949 {
	static int N,K,ans,max;
	static int map[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void dfs(int y,int x,int cnt,int pre,boolean flag) {
		v[y][x] = true;
		ans = Math.max(cnt, ans);
		for(int i=0;i<4;i++) {
			int ny = y + dr[i][0]; 
			int nx = x + dr[i][1];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(v[ny][nx]) continue;
			if(!flag) {
				if(map[ny][nx] < map[y][x]) {
					dfs(ny,nx,cnt+1,map[ny][nx],flag);
				}
				else if(map[ny][nx]-K < map[y][x])dfs(ny,nx,cnt+1,map[y][x]-1,true);
			}else {
				if(map[ny][nx] < pre) {
					dfs(ny,nx,cnt+1,map[ny][nx],flag);
				}
			}
		}
		v[y][x] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			ans = 0;
			max = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					v = new boolean[N][N];
					if(map[i][j] == max) dfs(i,j,1,max,false);
				}
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
