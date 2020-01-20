package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B16637 {
	static int n,sum1,sum2,ans,total;
	static int a[][];
	static boolean v[];
	//static LinkedList<Integer> li = new LinkedList<Integer>();
	public static void dfs(int cnt,int d) {
		if(cnt == n/2) {
			sum1 = 0;
			sum2 = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(v[i]&&v[j]&&i!=j) {
						sum1 += a[i][j];
					}
					if(!v[i]&&!v[j]&&i!=j) {
						sum2 += a[i][j];
					}
				}
			}
			total = Math.abs(sum1-sum2);
			ans = Math.min(total, ans);
			return;
		}
		for(int i=d+1;i<=n;i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(cnt+1,i);
				v[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		v = new boolean[n+1];
		a = new int[n+1][n+1];
		ans = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		dfs(0,1);
		System.out.println(ans);
	}
}
