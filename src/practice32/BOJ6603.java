package practice32;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ6603 {
	static int a[];
	static int k,cnt;
	static ArrayList<Integer> li = new ArrayList<Integer>();
	static StringBuffer sb = new StringBuffer();
	public static void dfs(int v,String s) {
		if(cnt == 6) {
			sb.append(s + "\n");
		}
		else {
			
		}
		--cnt;
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		//while(k = sc.nextInt()) != 0 이렇게 가능.
		while(true) {
			k = sc.nextInt();
			if(k == 0) break;
			a = new int[k];
			for(int i=0;i<k;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0;i<k;i++) {
				cnt=1;
				dfs(i,a[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
