package aaa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//위상정렬이 아닌 경우 0 출력 
public class B2623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int indegree[] = new int[N+1];
		boolean v[] = new boolean[N+1];
		ArrayList<Integer> li[] = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			li[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int num = sc.nextInt();
			int s = sc.nextInt();
			for(int j=1;j<num;j++) { //중요한 부분! 간선이 어디에서 어디로가는지! 
				int e = sc.nextInt();
				indegree[e]++;
				li[s].add(e);
				s = e;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
				v[i] = true;
			}
		}
		LinkedList<Integer> ans = new LinkedList<Integer>();
		while(!q.isEmpty()) {
			ans.add(q.peek());
			int cur = q.poll();
			for(int i=0;i<li[cur].size();i++) {
				int next = li[cur].get(i);
				indegree[next]--;
				if(indegree[next]==0) {
					q.add(next);
					v[next] = true;
				}
			}
		}
		boolean flag = false;
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(!v[i]) break;
			cnt++;
		}
		if(N != cnt) System.out.println(0);
		else {
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
