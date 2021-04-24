package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class q4 {
	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < snapshots.length; i++) {
			String s = snapshots[i][0];
			Integer n = Integer.parseInt(snapshots[i][1]);
			map.put(s, n);
		}
		
		// ["1", "SAVE", "ACCOUNT2", "100"],
		LinkedList<String> li = new LinkedList<String>();
		for (int i = 0; i < transactions.length; i++) {
			String id = transactions[i][0];
			if (li.contains(id))
				continue;
			else
				li.add(id);
			String m = transactions[i][1];
			String ac = transactions[i][2];
			Integer n = Integer.parseInt(transactions[i][3]);
			if (m.equals("SAVE")) {
				if (map.containsKey(ac)) {
					int num = map.get(ac);
					map.put(ac, num + n);

				} else {
					map.put(ac, n);
				}
			} else if (m.equals("WITHDRAW")) {
				if(map.containsKey(ac)) {
					int num = map.get(ac);
					map.put(ac, num - n);

				}else {
					map.put(ac, -n);
				}
			}
		}
		String ans[][] = new String[map.size()][2];
		int idx = map.size()-1;
		for (Entry<String, Integer> e : map.entrySet()) {
			ans[idx][0] = e.getKey();
			ans[idx][1] = Integer.toString(e.getValue());
			idx--;
		}

		return ans;
	}

	public static void main(String[] args) {

		String a[][] = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String b[][] = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };
	
		String ab[][] = solution(a,b);
		for(int i=0;i<ab.length;i++) {
			System.out.println(ab[i][0]+","+ab[i][1]);
		}
		
	}
}
