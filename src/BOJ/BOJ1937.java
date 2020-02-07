package BOJ;
import java.util.*;
public class BOJ1937 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		int dp[][] = new int[n+1][n+1];
		int max1;
		int max2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(i==0||j==0) dp[i][j]=arr[i][j];
				else {
					max1=Math.max(dp[i][j-1], dp[i-1][j]);
					max2=Math.max(dp[i][j+1], dp[i+1][j]);
					dp[i][j]+=Math.max(max1, max2);
				}
				
			}
		}
		System.out.println(dp[n][n]);
	}
}
