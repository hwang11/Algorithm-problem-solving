package practice25;
import java.util.Scanner;
//계단오르기.
public class BOJ2579 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int dp[][] = new int[n+1][2];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		dp[1][0] = dp[1][1] = a[1]; 
		
		for(int i=2;i<=n;i++) {
			dp[i][0] = dp[i-1][1] + a[i]; //i번째칸을 1칸 뛰어올라오는경우.	
			//i-1번째칸을 2칸뛰어올라오는 경우 + a[i]지금밟는 칸. 3칸연속방지.
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + a[i];//i번째칸을 2칸뛰어올라오는경우.
			//i-2번째칸을 2칸뛰어올라오는경우, 1칸뛰어올라오는경우를 비교.
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}
