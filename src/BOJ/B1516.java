package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1516 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list[] = new ArrayList[N+1];
		int indegree[] = new int[N+1];
		int time[] = new int[N+1];
		int ans[] = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=N;i++) {
			int t = sc.nextInt();
			time[i] = t;
			while(true) {
				int n = sc.nextInt();
				if(n==-1) break;
				list[n].add(i);
				indegree[i]++;
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) q.add(i);
			ans[i] += time[i];
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0;i<list[cur].size();i++) {
				int next = list[cur].get(i);
				indegree[next]--;
				System.out.printf("ans[%d]: %d, ans[%d]+time[%d] : %d\n",next, ans[next], cur,next,ans[cur]+time[next]);
				ans[next] = Math.max(ans[next], ans[cur]+time[next]);
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(ans[i]);
		}
		
	}
}
