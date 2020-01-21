package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R1966 {
	static LinkedList<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			q = new LinkedList<Integer>();
			for (int j = 0; j < n; j++) {
				q.add(sc.nextInt());
			}
			boolean flag = false;
			int cnt = 0;
			while (true) {
				flag = false;
				int size = q.size();
				for (int j = 1; j < size; j++) { // q size가 1이면 이 조건문에서 걸러지므로 별도의 처리를 할 필요가 없음
					if (q.peek() < q.get(j)) {
						q.add(q.poll());
						flag = true;
						m = (m == 0) ? q.size() - 1 : --m;
						break;
					}
				}
				if (!flag) {
					cnt++;
					q.poll();
					if (m == 0) {
						break;
					}
					m--;
				}
			}
			System.out.println(cnt);
		}
	}
}
