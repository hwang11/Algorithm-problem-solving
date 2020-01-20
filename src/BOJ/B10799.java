package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class B10799 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack stack = new Stack();
		int cnt = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') stack.push(s.charAt(i));
			else { // )가 들어온 경우 
				stack.pop();
				if(s.charAt(i-1)=='(') cnt += stack.size(); //레이저이면 잘려진 것만큼 개수를 더해야하기때문에  
				else cnt++; //파이프의 끝이면 남은 1만큼만 더해주면 
			}
		}
		System.out.println(cnt);
	}
}
