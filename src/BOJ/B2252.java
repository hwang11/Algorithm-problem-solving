package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2252 {
	public static void main(String[] args) {
		int N, M;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int indegree[] = new int[N + 1];
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			indegree[b]++;
		}
		for (int i = 1; i <= N; i++) {
			if(indegree[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<list[cur].size();i++) {
				int next = list[cur].get(i);
				indegree[next]--;
				if(indegree[next]==0) q.add(next);
			}
		}
	}
}
