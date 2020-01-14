package practice25;
import java.util.Scanner;
// 1,2,3더하기. 
public class BOJ9095 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int dp[] = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			for(int j=4;j<=n;j++) dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			System.out.println(dp[n]);
		}
	}
}
