package BOJ;

import java.util.LinkedList;
import java.util.Stack;

public class process {
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = new int[progresses.length];
		int cnt = 0; // 총 완료개수
		int arr[] = new int[progresses.length];
		LinkedList<Integer> li = new LinkedList<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			li.add(i);
		}
		int idx = 0;
		boolean flag = false;
		int ret = 0;
		Stack st = new Stack<Integer>();
		while (cnt < progresses.length) {
			for (int i = 0; i < li.size(); i++) {
				if (progresses[li.get(i)] >= 100) {
					if (i == 0) { // 배포.
						for (int j = 0; j < li.size(); j++) {
							if (progresses[li.get(j)] >= 100) {
								st.push(li.get(j));
							}
						}
						flag = true;
					}
				}
				progresses[li.get(i)] += speeds[li.get(i)];
			}
			if(flag) {
				cnt += st.size();
				arr[idx++] = st.size();
				for (int j = 0; j < st.size(); j++) {
					li.remove(st.pop());
				}
				st.clear();
				flag = false;
			}
			ret++;
		}
		answer = new int[idx];
		for (int i = 0; i < idx; i++) {
			answer[i] = arr[i];
			System.out.println(answer[i]);
		}
		return answer;
	}

	public static void main(String args[]) {
		int a[] = { 40, 93, 30, 55, 60, 65 };
		int b[] = { 60, 1, 30, 5, 10, 7 };
		solution(a, b);

	}
}
