package Algo2;

import java.util.Scanner;

public class B11724 {
	static int n,m,stan,cnt,r;
	static boolean a[][];
	static boolean v[];
	
	public static void dfs(int k) {
		v[k] = true;
		for(int i=1;i<=n;i++) {
			if(a[k][i] && !v[i]) {
				System.out.println(k+"->"+i);
				dfs(i);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new boolean[n+1][n+1];
		v = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = true;
			a[v2][v1] = true;
		}
		cnt = 0;
		for(int i=1;i<=n;i++) {
			if(!v[i]) {
				++cnt;
				System.out.println("dfs("+i+")");
				dfs(i);
			}
			
		}
		System.out.println(cnt);
	}
}
