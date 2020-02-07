package BOJ;

import java.util.Scanner;
//스트링에 담긴 숫자 크기 비교 가능! 인트형으로 변환안해도 
//2:25-2:32
public class B2908 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String a1 = "";
		String a2 = "";
		for(int i=s1.length()-1;i>=0;i--) {
			a1 += s1.charAt(i);
		}
		for(int i=s2.length()-1;i>=0;i--) {
			a2 += s2.charAt(i);
		}
		int n1 = Integer.parseInt(a1);
		int n2 = Integer.parseInt(a2);
		if(n1>n2) System.out.println(n1);
		else System.out.println(n2);
		
	}
}
