package codility;

import java.util.Stack;
//String b = "{[()()]}";

public class stack1 {
	public static int solution(String S) {
        // write your code in Java SE 8
		if(S.length()%2==1) return 0;
		if(S.isEmpty()) return 1;
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<S.length();i++) {
			char now = S.charAt(i);
			if(now == '{' || now == '(' || now == '[') {
				st.push(now);
			}
			else {
				if(now == '}') {
					if(st.isEmpty() || st.pop() != '{') return 0;
				}
				else if(now == ')') {
					if(st.isEmpty() || st.pop()!= '(') return 0;
				}
				else if(now == ']') {
					if(st.isEmpty() || st.pop()!= '[') return 0;
				}
			}
		}
		if(st.isEmpty()) return 1;
		else return 0;
    }
	public static void main(String[] args) {
		//{[()()]}
		//([)()]
		String b = "{[()()]}";
		String a = "([)()]";
		System.out.println(solution(a));
		System.out.println(solution(b));
	}
}
