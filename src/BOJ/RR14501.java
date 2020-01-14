package Algo10;

import java.util.Scanner;

public class RR14501 {
	static int n,ans;
	static int t[];
	static int p[];

	public static void dfs(int idx,int sum) {
		if(idx == n+1) {
			ans = Math.max(sum, ans);
			return;
		}
		if(idx + t[idx] <= n+1) {
			dfs(idx + t[idx], sum+p[idx]);
		}
		dfs(idx+1,sum);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = new int[n+1];
		t = new int[n+1];
		ans = 0;
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		dfs(1,0);
		System.out.println(ans);
		
	}
}
