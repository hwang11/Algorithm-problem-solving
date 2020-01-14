package han;

import java.util.Stack;

public class stock {
//	public static int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        for(int i=0;i<prices.length-1;i++) {
//        	for(int j=i+1;j<prices.length;j++) {
//        		if(prices[i]>prices[j]) {
//        			answer[i] = (j-i);
//        			break;
//        		}
//        		if(j== prices.length-1) answer[i] = j-i;
//        	}
//        }
//        return answer;
//    }
	public static int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
                System.out.printf("beginIdx: %d terms[beginIdx]:%d\n",beginIdx,terms[beginIdx]);
            }
            beginIdxs.push(i);
        }
        
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
	public static void main(String args[]) {
		int a[] = {1, 2, 3, 2, 3};
		solution(a);
	}
}
