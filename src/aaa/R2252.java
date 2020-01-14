package aaa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int indegree[] = new int[N+1];
		ArrayList<Integer> li[] = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			li[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			li[x].add(y);
			indegree[y]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			System.out.print(q.peek()+" ");
			int cur = q.poll();
			
			for(int i=0;i<li[cur].size();i++) {
				int next = li[cur].get(i);
				indegree[next]--;
				if(indegree[next] ==0) q.add(next);
			}
		}
	}
}
