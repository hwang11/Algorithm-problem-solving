package aaa;

import java.util.Arrays;
import java.lang.*;
public class Greedy3 {
	
	 public static String solution(String number, int k) {
	        String answer = "";
	        StringBuilder sb = new StringBuilder();

	        int max;
	    	char m;
	        boolean v[] = new boolean[number.length()];
	        int a[];
	        a = new int[4];
	        
	        int d = number.length() - k;
	        int idx = 0;
	        for(int i=0;i<d;i++) { //4자리수면 4번 뽑기 
	        	max = 0;
	        	m = ' ';
	        	for(int j=idx;j<number.length()-d+i+1;j++) {
	        		if(v[j]) continue;
	        		if(max<number.charAt(j)) {
	        			idx = j;
	        			m = number.charAt(j);
	        			max = number.charAt(j)-0;
	        		}
	        	}
	        	v[idx] = true;
	        	sb.append(m);
    			//System.out.println("number"+number);
	        }
	        answer = sb.toString();
	        System.out.println(answer);
	        return answer;
	    }
	public static void main(String[] args) {
		solution("1924",2);
		solution("1231234",3); //3234 
		solution("4177252841",4); //775841
	}
}
