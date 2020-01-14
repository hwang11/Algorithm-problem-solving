package han;

import java.util.Scanner;

public class B10451 {
	static int ad[][];
	static boolean v[];
	static int N,cnt;
	static void dfs(int d) {
		v[d] = true;
		for(int i=1;i<=N;i++) {
			if(ad[d][i] == 1 && !v[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			N = sc.nextInt();
			cnt = 0;
			v = new boolean[N+1];
			ad = new int[N+1][N+1];
			for(int j=1;j<=N;j++) {
				int d = sc.nextInt();
				ad[j][d] = 1;
			}
			for(int j=1;j<=N;j++) {
				if(!v[j]) {
					dfs(j);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
