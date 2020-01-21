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
				int size = q.size(); //q의 상태가 계속 변화하므로 그때그때 size 저장
				boolean flag = false;
				for (int j = 1; j < size; j++) { // 큐의 사이즈가 1이라면 이 반복문을 돌지 않음.  
					flag = false;
					if (q.get(0).value < q.get(j).value) { // 하나라도 큰게 있으면 인쇄할 수 없음
						q.addLast(q.get(0)); //우선순위가 더 높은게 있다면 뒤로 가야함  
						q.removeFirst();
						flag = true; //우선순위가 높은 인쇄물이 뒤에 존재하는 것을 알려주기 위한 변수  
						break; //더 우선순위가 높은 인쇄물이 있다면 더 이상 반복문 돌릴 필요X
					}
				}

				if (!flag) { // 현재출력할 인쇄물보다 우선순위가 높은 인쇄물이 없다면
					cnt++;
					if (q.get(0).idx == m) { //현재 출력하려는 인쇄물이 처음 M번째 위치했던 인쇄물이라면
						break;
					}
					q.removeFirst(); // 인쇄
				}
			}
			System.out.println(cnt);
		}
	}

	public static class Dot { // 처음 큐의 인덱스 정보와 값을 함께 저장하기 위한 클래스
		int idx;
		int value;

		public Dot(int i, int v) {
			this.idx = i;
			this.value = v;

		}
	}
}