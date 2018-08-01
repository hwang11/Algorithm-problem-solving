package practice25;

import java.util.Scanner;
//누적합이 음수면, 더해주지 않고. 거기부터 새로dp배열시작.
//음수면 더해봤자 작아지니까.
public class BOJ1912 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int dp[] = new int[n+1];
		int max = 0;
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		dp[1] = a[1];
		max = dp[1];
		for(int i=2;i<=n;i++) {
			dp[i] = Math.max(dp[i-1]+a[i], a[i]);
			if(max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}
}
