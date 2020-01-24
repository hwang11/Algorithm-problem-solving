package Programmers.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class q4 {
    
    static boolean visit[];
	static List<String> list = new ArrayList<>();
	static String route = "";
    
    public static String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
		
		for(int i = 0 ; i < tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				visit[i] = true;
				route = tickets[i][0] + ",";
				dfs(tickets, tickets[i][1], 1);
				visit[i] = false;
			}
		}
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
    }
	
	public static void dfs(String[][] tickets, String end, int count) {
		
		route += end + ",";
		if(count==tickets.length) {
			list.add(route);
			return;
		}
		
		for(int i = 0 ; i < tickets.length ; i++) {
			String depart = tickets[i][0];
			String desti = tickets[i][1];
			
			if(end.equals(depart) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, desti, count+1);
				visit[i] = false;
				route = route.substring(0, route.length()-4);
			}
		}
	}
	public static void main(String[] args) {
		String a[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		solution(a);
	}
}