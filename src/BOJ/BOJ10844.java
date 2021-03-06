package BOJ;

import java.util.Scanner;
//더한순간에 오버플로 날수도있어서 계속 나눠줌.
public class BOJ10844 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) dp[i][j] = dp[i-1][1] %1000000000;
				else if(j==9)dp[i][j] = dp[i-1][8] %1000000000;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] %1000000000;
			}
		}
		int sum = 0;
		for(int i=1;i<10;i++) {
			sum += dp[n][i]%1000000000;
		}
		System.out.println(sum%1000000000);
		
	}
}
