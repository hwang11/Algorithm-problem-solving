package Algo3;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
	static int n;
	public static boolean check(String s) {
		Stack stack = new Stack();
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j) == '(') {
				stack.push('(');
			}
			else {
				if(stack.contains('(')) stack.pop();
				else return false;
			}
		}
		if(stack.contains('(')) return false;
		return true;
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String str = sc.next();
			if(check(str)) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
}
