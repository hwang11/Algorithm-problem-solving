package Programmers.스택큐;

import java.util.Stack;

public class Stock {
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<prices.length;i++) {
        	while(!st.isEmpty() && prices[st.peek()]> prices[i]) {
        		
        			int idx = st.pop();
        			answer[idx] = i-idx;
        		
        	}
            st.add(i);
        }
        
        while(!st.isEmpty()) {
        	int idx = st.pop();
			answer[idx] = prices.length-1-idx;
        }
        for(int i=0;i<answer.length;i++) {
        	System.out.println(answer[i]);
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 2, 3};
		solution(a);
	}
	
}
