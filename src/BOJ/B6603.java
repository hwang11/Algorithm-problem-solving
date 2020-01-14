package Algo4;

import java.util.Scanner;

public class B6603 {
	static int n;
	static int arr[];
	static int b[];
	public static void dfs(int cnt,int i) {
		if(cnt == 6) {
			for(int j=1;j<=n;j++) {
				System.out.print(b[j]+" ");
			}
			System.out.println();
			return;
		}
		if(i == n) {
			return;
		}
		b[cnt] = arr[i]; 
		
		dfs(cnt+1,i+1);
		dfs(cnt,i+1);

	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			arr = new int[n+1];
			b = new int[n+1];
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=1;i<=n;i++) {
				dfs(0,i);
			}
		}
	}
}
