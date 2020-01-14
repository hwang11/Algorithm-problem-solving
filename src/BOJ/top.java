package han;

import java.util.LinkedList;

public class top {
    public static int[] solution(int[] heights) {
        int[] answer = {};
        LinkedList<Integer> li = new LinkedList<Integer>();
        li.add(0);
        boolean flag;
        for(int i=1;i<heights.length;i++) {
        	flag = false;
        	for(int j=i-1;j>=0;j--) {
        		if(heights[j] > heights[i]) {
        			li.add(j+1);
        			flag = true;
        			break;
        		}
        	}
        	if(!flag) li.add(0);
        }
        answer = new int[li.size()];
        for(int i=0;i<li.size();i++) {
        	answer[i] = li.get(i);
        	//System.out.println(answer[i]);
        }
        return answer;
    }
	public static void main(String args[]) {
		int a[] = {6,9,5,7,4};
		solution(a);
	}
}