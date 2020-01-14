package Algo12;

import java.util.Arrays;
import java.util.Scanner;

public class RR2105 {
	static int n,start_x,start_y,ans;
	static boolean v[][];
	static boolean num[];
	static int map[][];
	static int dir[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static void dfs(int y,int x,int l,int d) {
		if(d == 4) return;
		int ny = y + dir[d][0];
		int nx = x + dir[d][1];
		if(ny < 0 || nx < 0 || ny >= n || nx >=n) return;
		if(v[ny][nx] || num[map[ny][nx]]) {
			if(ny == start_y && nx == start_x) {
				ans = Math.max(ans, l);
				return;
			}
			else return;
		}
		v[ny][nx] = true;
		num[map[ny][nx]] = true;
		dfs(ny,nx,l+1,d);
		dfs(ny,nx,l+1,d+1);
		v[ny][nx] = false;
		num[map[ny][nx]] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			v = new boolean[n][n];
			num = new boolean[101];
			map = new int[n][n];
			Arrays.fill(num, false);
			ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = false;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					start_x = j;
					start_y = i;
					v[i][j] = true;
					num[map[i][j]] = true;
					dfs(i,j,1,0);
					v[i][j] = false;
					num[map[i][j]] = false;
				}
			}
			if(ans < 4) ans = -1;
			System.out.printf("#%d %d\n",t,ans);
		}	
	}
}
