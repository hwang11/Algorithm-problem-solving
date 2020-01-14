package Expert;

import java.util.Scanner;

public class BOJ6603 {
	static int n;
	static boolean v[];
	static int a[];
	public static void dfs(int k,int cnt) {
		v[k] = true;
		if(cnt == 6) {
			for(int i=0;i<n;i++) {
				if(v[i]) {
					System.out.print(a[i]+" ");
				}
			}
			System.out.println();
		}
		else {
			for(int i=k+1;i<n;i++) {
				dfs(i,cnt+1);
			}
		}
		v[k] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		v = new boolean[n];
		a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			v[i] = true;
			dfs(i,1);
			v[i] = false;
		}
		
	}
}
