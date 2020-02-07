package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class R9012 {
	public static boolean check(String s) {
		Stack stack = new Stack();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') stack.push('(');
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
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String s = sc.next();
			if(check(s)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
