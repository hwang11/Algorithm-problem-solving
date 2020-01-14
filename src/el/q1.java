package el;

import java.util.LinkedList;

import java.util.Scanner;

public class q1 {
	static int max,mk;
	public static int[] solution(int N) {
		int[] answer = new int[2];
		for (int i = 2; i < 11; i++) {
			solve(N,i);
		}
		//System.out.println(mk+","+max);
		answer[0] = mk;
		answer[1] = max;
		return answer;
	}

	public static void main(String[] args) {
		int value = 10;
		solution(value);
	}

	public static void solve(int num,int k){
        LinkedList li= new LinkedList();
        String ans="";
        while(num>0){
            if(num%k>9) li.add((char)(num%k+55));
            else li.add(num%k);
            num=num/k;
        }
        while(!li.isEmpty()) ans+=li.pollLast();
        int sum = 1;
        for(int i=0;i<ans.length();i++) {
        	sum *= (ans.charAt(i)-48);
        }
        if(max < sum) {
        	max = sum;
        	mk = k;
        }else if(max == sum) {
        	if(mk < k) {
        		mk = k;
        	}
        }
    }

}