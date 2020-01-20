package BOJ;

import java.util.Scanner;

public class BOJ2133 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		dp[0]=1;
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			if(i%2!=0) dp[i]=0;
			else dp[i]=dp[i-2]*2+1;
		}
		
		System.out.println(dp[n]);
	}
}
