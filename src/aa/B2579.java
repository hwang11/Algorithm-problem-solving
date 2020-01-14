package aa;

import java.util.Scanner;

public class B2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[301];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[301];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[1], arr[0]+arr[1]);
		dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
		for(int i=3;i<n;i++) {
			dp[i] = Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]);
		}
		System.out.println(dp[n-1]);
	}
}
