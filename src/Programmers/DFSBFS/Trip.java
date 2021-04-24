package Programmers.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Trip {
	//static String[][] t;
	static boolean v[];
	static ArrayList<String> list;
	public static void dfs(String present, String answer, String[][] t, int cnt) {
		if(cnt == t.length) {
			list.add(answer);
			return;
		}
		
		for(int i=0;i<t.length;i++) {
			if(t[i][0].equals(present) && !v[i]) {
				v[i] = true;
				dfs(t[i][1],answer +" "+t[i][1],t,cnt+1);
				v[i] = false;
			}
		}
	}
	public static String[] solution(String[][] tickets) {
        //t = tickets;
        list = new ArrayList<String>();
        v = new boolean[tickets.length];
		dfs("ICN","ICN",tickets,0);
		Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        for(int i=0;i<answer.length;i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//String s[][] = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String s[][] ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		solution(s);
	}
}
