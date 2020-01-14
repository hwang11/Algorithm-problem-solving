package han;

import java.util.Scanner;

public class B2606 {
	static int N,M,cnt;
	static int ad[][];
	static boolean v[];
	static void dfs(int d) {
		v[d] = true;
		for(int i=1;i<=N;i++) {
			if(ad[d][i] == 1 && ad[i][d] == 1 && !v[i]) {
				dfs(i);
				cnt++;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ad = new int[N+1][N+1];
		v = new boolean[N+1];
		cnt = 0;
		for(int i=0;i<M;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			ad[v1][v2] = 1;
			ad[v2][v1] = 1;
		}
		dfs(1);
		System.out.println(cnt);
	}
}
