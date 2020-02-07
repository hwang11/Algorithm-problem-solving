package BOJ;

import java.util.Scanner;

public class BOJ15649 {
	static int n,m;
	static boolean visit[];
	static int a[];
	static void dfs(int cnt) {
		if(cnt == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int i=1;i<=n;i++) {
				if(!visit[i]) {
					visit[i] = true;
					a[cnt] = i;
					dfs(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n+1];
		a = new int[9];
		dfs(0);
	}
}
