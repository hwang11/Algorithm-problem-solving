package Programmers;

import java.util.LinkedList;

public class q3 {
	static LinkedList<Integer> li;
	static boolean v[];
	static char r[];
	static int max;
	static void dfs(int idx,int dep,String road,int n) {
		if(dep <= n) {
			if(max == road.length()) return;

			StringBuilder s= new StringBuilder(road);
			for(int i=0;i<v.length;i++) {
				if(v[i]) {
					int num = li.get(i);
					s.setCharAt(num, '1');
				}
			}
			int cnt = 0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='1') cnt++;
				else cnt = 0;
				max = Math.max(cnt, max);
			}
		}
		for(int i=idx;i<li.size();i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(i+1,dep+1,road,n);
			v[i] = false;
		}
	}
    public static int solution(String road, int n) {
        int answer = -1;
        r = road.toCharArray();
        li = new LinkedList<Integer>();
        v = new boolean[r.length];
        max =0;
        for(int i=0;i<r.length;i++) {
        	if(r[i]=='0') li.add(i);
        }
        dfs(0,0,road,n);
        answer = max;
        return answer;
    }
    public static void main(String[] args) {
    	String s1 ="111011110011111011111100011111";
    	int n1=3;//	18
    	String s2="001100";
    	int n2 =5;//	6
    	System.out.println(solution(s1,n1));
    	System.out.println(solution(s2,n2));
	}
}
