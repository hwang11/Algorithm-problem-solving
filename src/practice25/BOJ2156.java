package practice25;

import java.util.Scanner;

public class BOJ2156 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int dp[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		//n=1인 경우를 방지.
		for (int i = 1; i < 3 && i <= n; i++){
	        if (i == 1)
	            dp[i] = a[i];
	        else
	            dp[i] = a[i] + a[i - 1];
	    }
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-2]+a[i],dp[i-1]);
			dp[i] = Math.max(dp[i-3]+a[i-1]+a[i], dp[i]);
 		}
		System.out.println(dp[n]);
	}
}
