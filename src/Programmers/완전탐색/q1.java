package Programmers.완전탐색;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

//모의고사 

public class q1 {
	static int[] a = {1, 2, 3, 4, 5};
	static int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
	static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	public static int[] solution(int[] answers) {
        int[] cnt = new int[3];
        int aidx = 0,bidx = 0 ,cidx = 0;
        for(int i=0;i<answers.length;i++) {
        	aidx = i%a.length;
        	bidx = i%b.length;
        	cidx = i%c.length;
        	if(a[aidx]==answers[i]) cnt[0]++;
        	if(b[bidx]==answers[i]) cnt[1]++;
        	if(c[cidx]==answers[i]) cnt[2]++;
        }
        int max = 0;
        for(int i=0;i<3;i++) {
        	if(max<cnt[i]) {
        		max = cnt[i];
        	}
        }
        LinkedList<Integer> li = new LinkedList<Integer>(); 
        for(int i=0;i<3;i++) {
        	if(max == cnt[i]) {
        		li.add(i+1);
        	}
        }
        int rank[] = new int[li.size()];
        for(int i=0;i<li.size();i++) {
        	rank[i] = li.get(i);
        }
        Arrays.sort(rank);
        for(int i=0;i<rank.length;i++) {
        	System.out.println(rank[i]);
        }
        return rank;
    }
	public static void main(String[] args) {
		//int a[] = {1,2,3,4,5};
		int a[] = {1,3,2,4,2};
		solution(a);
	}
}
