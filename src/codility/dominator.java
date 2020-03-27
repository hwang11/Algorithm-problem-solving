package codility;

import java.util.HashMap;
import java.util.LinkedList;

public class dominator {
    public static int solution(int[] A) {
        // write your code in Java SE 8
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int cnt = 0;
    	int idx = -1;
    	if(A.length==0) return -1;
    	for(int i=0;i<A.length;i++) {
    		if(map.containsKey(A[i])) {
    			int v = map.get(A[i]);
        		map.put(A[i], v+1);
        		cnt = v+1;
    		}
    		else {
    			map.put(A[i], 1);
    			cnt = 1;
    		}
    		if(A.length/2 < cnt) {
    			//idx = i;
    			return i; //찾자마자 바로리턴 
    		}
    	}
//    	int M = A[idx]; => 이렇게 짜면, 지배가자 없는 경우에 idx값이 -1이 되어 A[-1]을 부르게 되서 에러 발생 
//    	if(idx == -1) return -1; //지배자 없음! 
//    	for(int i=0;i<A.length;i++) {
//    		if(M == A[i]) return i;
//    	}
    	return -1;
    }
    public static void main(String[] args) {
    	int a[] = {3,4,3,2,3,-1,3,3};
    	int b[] = {1};
    	int c[] = {0,0,1,1,1};
    	int d[] = {1,1,1,1};
    	System.out.println(solution(a));
    	System.out.println(solution(b));
    	System.out.println(solution(c));
    	System.out.println(solution(d));
    	
	}
}
