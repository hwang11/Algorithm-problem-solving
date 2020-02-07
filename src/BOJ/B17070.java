package BOJ;

import java.util.Scanner;

public class B17070 {
	static int N,ans;
	static int map[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{1,1}};
	static void dfs(int x,int y,int d) {
		if(x == N && y == N) {
			ans++;
			return;
		}
		for(int i=0;i<3;i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
			if(d==0 && i==1) continue;
			if(d==1 && i==0) continue;
			if(i==2) {
				if(map[nx][ny] == 1 || map[nx][ny-1] == 1 || map[nx-1][ny] == 1) continue;
			}
			else if(map[nx][ny] == 1) continue;
			if(v[nx][ny]) continue;
			v[nx][ny] = true;
			dfs(nx,ny,i);
			v[nx][ny] = false;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		v = new boolean[N+1][N+1];
		ans = 0;
		dfs(1,2,0);
		System.out.println(ans);
	}
}
