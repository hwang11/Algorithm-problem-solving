package Programmers;

import java.util.LinkedList;
import java.util.Stack;

public class q1 {
	static LinkedList<Character> li;
	static boolean chk(char c) {
		for(int i=0;i<li.size();i++) {
			if(li.get(i)==c) {
				li.remove(i);
				return true;
			}
		}
		return false;
	}
	public static int solution(String inputString) {
        int answer = -1;
        char[] a = inputString.toCharArray();
        li = new LinkedList<Character>();
        answer = 0;
        for(int i=0;i<inputString.length();i++) {
        	if(a[i] == '(' || a[i] == '[' || a[i] == '{' || a[i] == '<') {
        		li.add(a[i]);
        	}else {
        		if(a[i] == ')') {
        			if(chk('(')) {
        				answer++;
        				continue;
        			}else return -1;
        		}
        		if(a[i] == ']') {
        			if(chk('[')) {
        				answer++;
        				continue;
        			}else return -1;
        		}
        		if(a[i] == '>') {
        			if(chk('<')) {
        				answer++;
        				continue;
        			}else return -1;
        		}
        		if(a[i] == '}') {
        			if(chk('{')) {
        				answer++;
        				continue;
        			}else return -1;
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		String s1 = "Hello, world!";//	0
		String s2 = "line [plus]";//	1
		String s3 = "if (Count of eggs is 4.) {Buy milk.}";//	2
		String s4 = ">_<";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
//        LinkedList<Character> li = new LinkedList<Character>();
//
//		for(int i=0;i<s1.length();i++) {
//			li.add(s1.charAt(i));
//		}
//		li.remove(',');
//		li.get
	}
}
