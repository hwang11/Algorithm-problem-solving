package Programmers.힙;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class q1 {
	static PriorityQueue<Integer> pq;
	static public int solution(int[] scoville, int K) {
		int answer = 0;
		Arrays.sort(scoville);
		pq = new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		int n = 0;
		while (pq.peek() < K) {
			if (pq.size() == 1) {
				return -1;
			}
			n = pq.poll() + pq.poll() * 2;
			pq.add(n);
			answer++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 9, 10, 12 };
		solution(a, 7);
	}
}
