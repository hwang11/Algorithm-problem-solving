package Graph;

import java.util.Scanner;

public class BOJ6603 {
	static int a[];
	static int copy[];
	//static int cnt;

//	public static void dfs(String s,int index) {
//		if(s.length() == 12 || index == 5) {
//			System.out.println(s);
//			return;
//		}
//		else {
//			dfs(s + a[index]+" ",index+1);
//		}
//		
//	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int k = sc.nextInt();
			if(k==0) break;
			a = new int[k];
			for(int i=0;i<k;i++) {
				a[i] = sc.nextInt();
			}
			dfs("",0);
		}
	}
}
