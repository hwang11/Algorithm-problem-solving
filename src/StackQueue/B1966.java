package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 큐랑 링크드리스트 공부하기 
public class B1966 {
	static LinkedList<Dot> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt(); // 처음 큐에서 idx
			q = new LinkedList<Dot>();
			for (int j = 0; j < n; j++) {
				int v = sc.nextInt();
				q.add(new Dot(j, v));
			}

			int cnt = 0;
			while (true) {
				int size = q.size();
				boolean flag = false;
				for (int j = 1; j < size; j++) {
					flag = false;
					if (q.get(0).value < q.get(j).value) { // 하나라도 큰게 있으면 인쇄할 수 없음
						q.addLast(q.get(0));
						q.removeFirst();
						flag = true;
						break;
					}
				}

				if (!flag) {
					cnt++;
					if (q.get(0).idx == m) {
						break;
					}
					q.removeFirst(); // 인쇄
				}
			}
			System.out.println(cnt);
		}
	}

	public static class Dot {
		int idx;
		int value;

		public Dot(int i, int v) {
			this.idx = i;
			this.value = v;

		}
	}
}
