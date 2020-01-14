package han;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s1 = sc.nextLine();
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			Stack stack = new Stack();
			boolean flag = false;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='(') stack.push('(');
				else {
					if(stack.isEmpty()) {flag = true;
					System.out.println("NO");
					break;}
					stack.pop();
				}
			}
			if(!flag) {
				if(stack.isEmpty()) System.out.println("YES");
				else if(stack.contains('(')) System.out.println("NO");
			}
		}
	}
}
