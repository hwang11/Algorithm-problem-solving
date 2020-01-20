package BOJ;

import java.util.Scanner;

public class B1157 {
	public static void main(String args[]) {
		int a[] = new int[33];
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)-65>31) {
				//System.out.println(s.charAt(i)-65-32);
				a[s.charAt(i)-65-32]++;
			}
			else a[s.charAt(i)-65]++;
		}
		int max = 0;
		char maxc = ' ';
		for(int i=0;i<a.length;i++) {
			if(max < a[i]) {
				max = a[i];
				maxc = (char) ('A' + i);
			}
		}
		int cnt = 0;
		boolean flag = false;
		for(int i=0;i<a.length;i++) {
			if(max == a[i]) {
				cnt++;
			}
			if(cnt>=2) {
				flag = true;
			}
		}
		if(flag) System.out.println("?");
		else System.out.println(maxc);
		
	}
}
