package aaa;

import java.util.LinkedList;

//체육복 
public class P1 { 
	static int n1 = 5;
	static int lost1[] = {2,4};
	static int reserve1[] = {1,2,3};
	static int cnt;
	public static int solution(int n, int[] lost, int[] reserve) {
		int cnt = 0;
        int answer = 0;
        for(int i=0;i<reserve.length;i++) {
        	for(int j=0;j<lost.length;j++) {
        		if(reserve[i] == 1000 && lost[j] == 1000) continue;
        		if(reserve[i] == lost[j]) {
        			reserve[i] = 1000;
        			lost[j] = 1000;
        			cnt++;
        		}
        	}
        }
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(reserve[j] == 1000 || lost[i] == 1000) continue;
    			if(Math.abs(lost[i]-reserve[j])==1) { //옷이 맞으면 
        			reserve[j] = 1000;
        			cnt++;
        			break;
        		}
        	}
        }
        int d = lost.length - cnt;
        answer = n - d;
        return answer;
    }
	public static void main(String[] args) {
		solution(n1
				,lost1,reserve1);
	}
}
