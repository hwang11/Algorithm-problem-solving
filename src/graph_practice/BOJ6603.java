package graph_practice;

import java.util.Scanner;

public class BOJ6603 {
	static String s;
	static int a[] = new int[s.length()];
	static int copy[];
	//static int cnt;
	
	public static void dfs(String s) {
		if(s.length() == 6) {
			for(int i=1;i<=6;i++) {
				System.out.print(copy[i]+" ");
			}
		}
		else {
			copy = new int[s.length()];
			for(int i=1;i<copy.length;i++) {
				copy[i] = a[i];
			}
			
			dfs(s + a[i]);
		}
		--cnt;
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.nextInt() != 0) {
			int k = sc.nextInt();
			for(int i=0;i<k;i++) {
				a[i] = sc.nextInt();
			}
			dfs();
		}
		
	}
}
