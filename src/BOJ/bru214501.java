package Algo10;

import java.util.Scanner;

public class bru214501 {
	static int n,ans;
	static int t[],p[];
	public static void dfs(int idx,int sum) {
		if(idx >= n +1) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i=idx+t[idx];i<=n+1;i++) {
			dfs(i,p[idx]+sum);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 0;
		p = new int[n+1];
		t = new int[n+1];
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			dfs(i,0);
		}
		System.out.println(ans);
	}
}
