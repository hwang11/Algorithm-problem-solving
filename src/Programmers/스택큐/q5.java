package Programmers.스택큐;

import java.util.Stack;

public class q5 {
	public static int solution(String arrangement) {
        int answer = 0;
        char a[] = arrangement.toCharArray();
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<a.length;i++) {
        	if(a[i]=='(') {
        		st.push(a[i]);
        	}else {
        		if(a[i-1]=='(') { //레이저이면 
        			st.pop();
        			answer += st.size(); //스택크기 더해줌 
        		}else if(a[i-1] == ')') { //쇠막대기가끝날때 
        			answer++; //쇠막대기 끝날때 1씩 추가 
        			st.pop();
        		}
        		
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
		//System.out.println(solution("(((()(()()))(())()))(()())"));
	}
}
