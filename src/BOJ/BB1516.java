package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 예시 
5
10 -1
10 1 -1
4 1 -1
4 3 -1
3 2 3 -1
 * */
public class BB1516 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int indegree[] = new int[N + 1];
		ArrayList<Integer> li[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			li[i] = new ArrayList<Integer>();
		}
		int a[] = new int[N+1];
		int t[] = new int[N + 1];
		// list[a].add(b); // a가 b보다 우선,
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
			while (true) {
				int v = sc.nextInt();
				if (v == -1)
					break;
				li[v].add(i);
				indegree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(indegree[i] == 0) q.add(i);
			t[i] = a[i];
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<li[now].size();i++) {
				int next = li[now].get(i);
				indegree[next]--;
				System.out.printf("now:%d next:%d\n",now,next);
				System.out.printf("t[%d] + a[%d]:%d, t[%d]:%d\n",now,next,t[now]+a[next],next,t[next]);
				t[next] = Math.max(t[now] + a[next], t[next]);
				//t[next] = t[now] + a[next]; 이렇게 짜버려면 걸리는 시간의 최대를 고려하지 않게 되어버림 
				if(indegree[next] == 0) q.add(next);
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(t[i]);
		}
	}
}
