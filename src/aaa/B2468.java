package aaa;

import java.util.Scanner;

public class B2468 {
	static int N,min,max,ans,cnt;
	static int map[][];
	static boolean v[][];
	static int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void dfs(int x,int y,int h) {
		v[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(nx < 0 || ny < 0|| nx >= N || ny >=N) continue;
			if(v[nx][ny]) continue;
			if(map[nx][ny] <= h) continue;
			dfs(nx,ny,h);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		v = new boolean[N][N];
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(map[i][j], max);
				min = Math.min(min, map[i][j]);
			}
		}
		for(int i=0;i<=max;i++) {
			cnt = 0;
			v = new boolean[N][N];
			for(int k=0;k<N;k++) {
				for(int j=0;j<N;j++) {
					if(i<map[k][j]) {
						if(v[k][j]) continue; 
						dfs(k,j,i);
						cnt++;
					}
				}
			}
			ans = Math.max(cnt, ans);
		}
		System.out.println(ans);
	}
}
