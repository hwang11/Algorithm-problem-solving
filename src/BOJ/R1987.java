package BOJ;

import java.util.Scanner;

public class R1987 {
	static int r,c,cnt,ans;
	static int a[][];
	static boolean v[];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void dfs(int x,int y) {
		v[a[x][y]-65] = true;
		for(int i=0;i<4;i++) {
			int mx = x + dis[i][0];
			int my = y + dis[i][1];
			if(mx < 0 || mx >= r || my<0 || my >=c) continue;
			if(v[a[mx][my]-65]) continue;
			ans = Math.max(ans, ++cnt);
			dfs(mx,my);
		}
		--cnt;
		v[a[x][y]-65] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		a = new int[r][c];
		v = new boolean[26];
		
		
		for(int i=0;i<r;i++) {
			String s = sc.next();
			for(int j=0;j<c;j++) {
				a[i][j] = s.charAt(j);
			}
		}
		cnt = 1;
		ans = 1;
		dfs(0,0);
		System.out.println(ans);
	}
}
