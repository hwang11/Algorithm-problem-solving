package aaa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Stack31 {
	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		for (int i = 0; i < progresses.length; i++) {
			queue.add((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1);
		}
		List<Integer> result = new ArrayList<>();
		int standard = queue.poll();
		int cnt = 1;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (standard >= num) { //num이 100을 넘었다면 
				cnt++;
			} else {
				result.add(cnt);
				cnt = 1;
				standard = num; //기준 옮기기 
			}
		}
		result.add(cnt);
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		return answer;

	}

	public static void main(String[] args) {
		// [93, 30, 55, 60, 40, 65], [1, 30, 5, 10, 60, 7]
		// 기댓값 〉 [2, 4]
		// 실행 결과 〉 배열의 인덱스 0의 값이 다릅니다. 실행한 결괏값: 5, 기댓값: 2

		// 테스트 3
		// 입력값 〉 [40, 93, 30, 55, 60, 65], [60, 1, 30, 5, 10, 7]
		// 기댓값 〉 [1, 2, 3]
		int p1[] = { 93, 30, 55, 60, 40, 65 };
		int s1[] = { 1, 30, 5, 10, 60, 7 };
		int p2[] = { 40, 93, 30, 55, 60, 65 };
		int s2[] = { 60, 1, 30, 5, 10, 7 };
		int p[] = { 93, 30, 55 };
		int s[] = { 1, 30, 5 };

		solution(p1, s1);
		// solution(p,s);

	}
}
