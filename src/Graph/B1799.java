package Graph;

import java.util.Scanner;

public class B1799 {
	static int N;
	static int ans[],arr[][];
	static boolean colors[][];
	static int d[][] = {{-1,1},{-1,-1}};
	static boolean chk(int x,int y) {
		int nx,ny;
		for(int i=0;i<2;i++) {
			nx = x;
			ny = y;
			while(true) {
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
				if(arr[nx][ny]==2) return false;
				nx += d[i][0];
				ny += d[i][1];
			}
		}
		return true;
	}
	static void dfs(int idx, boolean black, int cnt) {
		for(int i=idx+1;i<N*N;i++) {
			int x = i/N;
			int y = i%N;
			if(arr[x][y] == 0 || !chk(x,y) || colors[x][y]!=black) continue;
			arr[x][y] = 2;
			dfs(i,black,cnt+1);
			arr[x][y] = 1;
		}
		ans[black? 0 : 1] = Math.max(cnt, ans[black? 0 :1]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = new int[2];
		arr = new int[N][N];
		colors = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				colors[i][j] = (i%2 == 0 && j%2 == 0) ||( i%2 != 0 && j%2 != 0);
			}
		}
		dfs(-1,true,0);
		dfs(-1,false,0);
		System.out.println(ans[0]+ans[1]);
 	}
}
