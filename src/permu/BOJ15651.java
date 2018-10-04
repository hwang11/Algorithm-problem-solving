package permu;

import java.util.Scanner;

public class BOJ15651 {
	static int n,m;
	static int a[];
//	public static void dfs(int d) {
//		if(d == m) {
//			for(int i=0;i<m;i++) {
//				System.out.print((a[i]+1)+" ");
//			}
//			System.out.println();
//		}
//		for(int i=0;i<n;i++) {
//			a[d]=i;
//			dfs(d+1);
//		}
//	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[10];
		for(int i=1;i<=n;i++) {
			System.out.print(i);
			for(int j=1;i<=n;j++) {
				System.out.print(j);
			}
		}
		//dfs(0);
	}
}
