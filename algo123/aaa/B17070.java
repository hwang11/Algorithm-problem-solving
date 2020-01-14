package aaa;

import java.util.Scanner;

public class B17070 {
	static int N,ans;
	static int arr[][];
	static int d[][] = {{0,1},{1,0},{1,1}};
	static boolean v[][];
	
	static void dfs(int x,int y,int dr) {
		if(x == N && y == N) {
			ans++;
			return;
		}
		for(int i=0;i<3;i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(dr==0&&i==1) continue;
			if(dr==1&&i==0) continue;
			if(nx < 0 || nx >N || ny < 0 || ny >N) continue;
			if(v[nx][ny]) continue;
			if(i==2) {
				if(arr[nx][ny] == 1 || arr[nx-1][ny] == 1 || arr[nx][ny-1]==1) continue;
			}
			if(arr[nx][ny] == 1) continue;
			v[nx][ny] = true;
			dfs(nx,ny,i);
			v[nx][ny] = false;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		v = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		v[1][1] = true;
		dfs(1,2,0);
		System.out.println(ans);
	}
	
}
