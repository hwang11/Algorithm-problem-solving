package practice25;

import java.util.Scanner;

public class BOJ1932 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n+1][n+1];
		int dp[][] = new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = a[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) dp[i][j] = dp[i-1][j] + a[i][j];
				else if(j==i) dp[i][j] = dp[i-1][j-1] + a[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + a[i][j];
			}
		}
		int max = dp[n-1][0];
		for(int i=1;i<n;i++) {
			if(max<dp[n-1][i]) max = dp[n-1][i];
		}
		System.out.println(max);
		
	}
}
