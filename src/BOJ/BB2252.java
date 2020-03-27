package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//LinkedList로 하면 원소하나씩 가져올때 시간 오래걸려서 시간초과 
public class BB2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> li[] = new ArrayList[N+1];
		int indegree[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			li[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			indegree[b]++;
			li[a].add(b);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			for(int i=0;i<li[now].size();i++) {
				int next = li[now].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
