	package han;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class best {
	public static int[] solution(String[] genres, int[] plays) {
		LinkedList<pair> li = new LinkedList<pair>();
		int[] answer = {};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) map.put(genres[i], map.get(genres[i]) + plays[i]);
			else map.put(genres[i], plays[i]);
		}
		for (String key : map.keySet()) li.add(new pair(key,map.get(key),0));
		
		albumComparator ac = new albumComparator();
		Collections.sort(li, ac);
		Collections.reverse(li);
		LinkedList<pair> best = new LinkedList<pair>();
		LinkedList<Integer> ans = new LinkedList<Integer>();
		
		for (int i = 0; i < li.size(); i++) {
			for (int j = 0; j < plays.length; j++) {
				if(li.get(i).kind.equals(genres[j])) best.add(new pair(genres[j],plays[j],j));
			}
			Collections.sort(best, ac);
			Collections.reverse(best);
			if(best.size()<2) ans.add(best.get(0).idx);
			else if(best.get(0).play == best.get(1).play) {
					if(best.get(0).idx<best.get(1).idx) {
						ans.add(best.get(0).idx);
						ans.add(best.get(1).idx);
					}
					else {
						ans.add(best.get(1).idx);
						ans.add(best.get(0).idx);
					}
			}
			else {
				ans.add(best.get(0).idx);
				ans.add(best.get(1).idx);
			}
			best.clear();
		}
		answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}

	public static void main(String args[]) {
		String a[] = { "classic", "pop", "classic", "classic", "pop" };
		int b[] = { 500, 600, 150, 800, 2500 };
		solution(a, b);
	}

	static class pair {
		String kind;
		int play;
		int idx;
		public pair(String k, int p,int i) {
			this.kind = k;
			this.play = p;
			this.idx = i;
		}
	}
	static class albumComparator implements Comparator<pair> { //컴페레이터 클래스 생성
		@Override
		public int compare(pair a, pair b) {
			int p1 = a.play;
			int p2 = b.play;
			if (p1 > p2) {
				return 1;
			} else if (p1 < p2) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
