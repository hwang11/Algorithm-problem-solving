package Algo10;

import java.util.Scanner;

public class B14501 {
	static int n;
	static int dp[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] t = new int[n + 1];
	    int[] p = new int[n + 1];
	    int[] dp = new int[n + 1];
	 
	    // http://mygumi.tistory.com/151
	 
	    for (int i = 1; i <= n; i++) {
	        t[i] = sc.nextInt();
	        p[i] = sc.nextInt();
	 
	        dp[i] = p[i];
	    }
	 
	    // dp[n] = n일때까지 얻은 수익
	 
	    for (int i = 2; i <= n; i++) {
	        for (int j = 1; j < i; j++) {
	 
	            if (i - j >= t[j]) {
	            	System.out.printf("p[%d]:%d + dp[%d]:%d, dp[%d]:%d\n",i,p[i],j,dp[j],i,dp[i]);
	                dp[i] = Math.max(p[i] + dp[j], dp[i]);
	            }
//	            else {
//	            	System.out.printf("%d - %d >= %d\n",i,j,t[j]);
//	            }
	 
	        }
	 
	    }
	 
	    int max = 0;
	    //for(int i=1;i<=n;i++) System.out.println(dp[i]);
	    
	    //기간 조건 확인 6은 2여야 가능하고 7은 1이어야 가능. 현재 그 상담을 택해서 기간내에 끝낼 수 있는지 확인 
	    //dp배열 중 가장 큰 값이 정답 
	    for (int i = 1; i <= n; i++) {
	        if (i + t[i] <= n + 1) {
	            if (max < dp[i]) {
	                max = dp[i];
	            }
	        }
	    }
	    System.out.println(max);

	}
}
