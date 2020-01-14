package han;

import java.util.Deque;
import java.util.LinkedList;
//시간초과 
public class printer {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<pair> dq = new LinkedList<pair>();
		char ans = (char) ('A' + location);
		for (int i = 0; i < priorities.length; i++) {
			dq.add(new pair(priorities[i], (char) ('A' + i)));
		}

		int cnt = 0;
		boolean flag = false;
		while (!dq.isEmpty()) {
			pair p = dq.poll();
			flag = false;
			for (int i = 0; i < dq.size(); i++) {
				if (p.pr < dq.get(i).pr) {
					dq.add(p);
					flag = true;
					break;
				}
			}
			if (!flag) {
				char ch = p.c;
				cnt++;
				//System.out.println(ch);
				if (ch == ans) {
					answer = cnt;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String args[]) {
		//int arr[] = {2,1,3,2};
		int arr[] = { 1, 1, 9, 1, 1, 1 };
		 //System.out.println(solution(arr,2));
		System.out.println(solution(arr, 0));
	}

	static class pair {
		int pr;
		char c;

		public pair(int p, char c) {
			this.pr = p;
			this.c = c;
		}
	}
}
