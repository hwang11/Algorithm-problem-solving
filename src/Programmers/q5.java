package Programmers;

import java.util.PriorityQueue;

public class q5 {
	public static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		for (int i = 0; i < dataSource.length; i++) {
			int cnt = 0;
			for (int k = 0; k < tags.length; k++) {
				for (int j = 1; j < dataSource[i].length; j++) {
					if (dataSource[i][j].equals(tags[k]))
						cnt++;
				}
			}
			if(cnt > 0 )q.add(new Pair(dataSource[i][0],cnt));
		}
		int size = q.size();
		answer = new String[size];
		for(int i=0;i<size;i++) {
			answer[i] = q.poll().name;
		}
		return answer;
	}

	public static void main(String[] args) {
		String a[][] = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" }, { "doc3", "t1", "t6", "t7" },
				{ "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String tags[] = { "t1", "t2", "t3" };
		solution(a,tags);
	}

	static class Pair implements Comparable<Pair> {
		String name;
		int cnt;

		public Pair(String n, int c) {
			this.name = n;
			this.cnt = c;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.cnt < p.cnt) {
				return 1;
			} else if (this.cnt > p.cnt) {
				return -1;
			} else {
				if (this.name.compareTo(p.name) > 1)
					return 1;
				else if (this.name.compareTo(p.name) < 0)
					return -1;
				return 0;
			}
		}
	}

}
