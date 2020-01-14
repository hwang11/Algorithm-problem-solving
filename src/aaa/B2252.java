package aaa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			indegree[y]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.add(i); //q에 indegree가 0인 정점이 들어감. 1번예제에서는 1,2노드가 들어감.
		}
		while(!q.isEmpty()) {
			System.out.print(q.peek()+" ");
			int current = q.poll();
			
			for(int i=0;i<list[current].size();i++) {
				int next = list[current].get(i);
				indegree[next]--; //연결된 간선을 -1 해줘야함 
				System.out.println("cur:"+current+" indegree["+next+"]: "+indegree[next]);
				if(indegree[next]==0) {
					q.add(next);
				}
			}
		}
	}
}
