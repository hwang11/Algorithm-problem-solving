package Expert;

import java.util.Scanner;

public class BOJ15650 {
	
	static int n,m;
	static boolean v[];
	public static void dfs(int k,int cnt) {
		v[k] = true;
		if(cnt == m) {
			for(int i=1;i<=n;i++) {
				if(v[i]) System.out.print(i+" ");
			}
			System.out.println();
		}
		
		for(int i=k+1;i<=n;i++) {
			dfs(i,cnt+1);
		}
		v[k] = false;
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			v[i] = true;
			dfs(i,1);
			v[i] = false;
		}
	
	}
}
