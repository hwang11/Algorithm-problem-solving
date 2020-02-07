package BOJ;
import java.util.*;
import java.io.*;
public class BOJ2504 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int tmp=1;
        int sum=0;
        for(int i=0;i<s.length();i++) {
			switch (s.charAt(i)){
				case '(':
					tmp*=2;
					stack.push(s.charAt(i));
					break;
				case '[':
					tmp*=3;
					stack.push(s.charAt(i));
					break;
				case ')':
					if (s.charAt(i-1) == '(') sum += tmp;
					if (stack.empty()) return !printf("0");
					if (stack. == '(') stack.pop();
					tmp /= 2; break;
					stack.pop();
					break;
				case ']':
					stack.pop();
					break;
					
			}
		}
		
		
		
		
	}
}
