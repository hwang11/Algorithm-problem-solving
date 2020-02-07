package BOJ;
import java.util.*;
public class BOJ14501 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][2];
		int dp[] = new int[n];
		int d = n;
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dp[0] = a[0][1]; 
		dp[1] = a[1][1];
		int i = 0;
		int j = i + a[i][0];
		while(d<0) {
			dp[j] = Math.max(dp[j], dp[j-1]);
			j = i + j;
			d -= j;
		}
			
		
		
	}
}
