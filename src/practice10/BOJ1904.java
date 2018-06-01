import java.util.*;
public class BOJ1904 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-2]+dp[i-1];
            dp[i]%=15746;
		}
		System.out.println(dp[n]);
		//출력문에서 나눠주면 안되는 이유는 for문을 돌다가 int범위를 넘어갈수있기때문  
	}
}
