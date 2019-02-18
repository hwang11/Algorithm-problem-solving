package Algo10;

import java.util.Scanner;

public class R14501 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		int t[] = new int[n+1]; // 소요 날짜 
		int p[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
			dp[i] = p[i];
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(i-j>=t[j]) {
					dp[i] = Math.max(dp[j]+p[i], dp[i]);
				}
			}
		}
		int ans = 0;
		for(int i=1;i<=n;i++) {
			if(i + t[i] <= n+1) {
				ans = Math.max(ans, dp[i]);
			}
		}
		System.out.println(ans);
	}
}
