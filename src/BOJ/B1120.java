package BOJ;

import java.util.Scanner;

public class B1120 {
	static int min;
	static void chk(String a,String b) {
		int cnt = 0;
		for(int i=0;i<b.length();i++) {
			if(a.charAt(i)!=b.charAt(i)) cnt++;
		}
		min = Math.min(cnt, min);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a1 = sc.next();
		String a2 = sc.next();
		min = Integer.MAX_VALUE;
		for(int i=0;i<a2.length()-a1.length()+1;i++) {
			String s = a2.substring(i, i+a1.length());
			chk(s,a1);
		}
		System.out.println(min);
	}
}
