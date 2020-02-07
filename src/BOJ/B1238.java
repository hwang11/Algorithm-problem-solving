package BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class B1238 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		Vector<Edge>[] adj = new Vector[N];
		for(int i=0;i<N;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			adj[s-1].add(new Edge(e-1,w));
		}
		int dis[] = new int [N];
		boolean v[] = new boolean[N];
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
		dis[X] = 0;
		pq.add(new Edge(X,0));
		
		while(!pq.isEmpty()) {
			int cur;
			do {
				cur = pq.poll().end;
			}while(!pq.isEmpty()&&v[cur]);
			
			for(Edge e:adj[cur]) {
				int next = e.end;
				if(dis[next] > dis[cur]+e.value) {
					dis[next] = Math.min(dis[next], dis[cur]+e.value);
					pq.offer(new Edge(next,dis[next]));
				}
			}

		}
		
	}
	public static class Edge implements Comparable <Edge>{
		int end;
		int value;
		public Edge(int e,int v) {
			this.end = e;
			this.value = v;
		}
		@Override
		public int compareTo(Edge o){
			return value <= o.value ? -1 : 1;
		}
	}
}
