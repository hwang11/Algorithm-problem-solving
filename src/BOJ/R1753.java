package Algo6;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by dasom on 2016-10-18.
 */
public class R1753 {
	public static final int INF = 10000000;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int V,E,S;
		V = sc.nextInt();
		E = sc.nextInt();
		S = sc.nextInt() - 1; //v를 0부터 시작하므로.
		
		Vector<Edge>[] adj = new Vector[V];
		int dis[] = new int[V];
		boolean v[] = new boolean[V];
		
		for(int i=0;i<adj.length;i++) {
			adj[i] = new Vector<>();
		}
		for(int i=0;i<E;i++) {
			int u = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			adj[u-1].add(new Edge(e-1,w));
		}
		for(int i=0;i<V;i++) {
			dis[i] = INF;
			v[i] = false;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		dis[S] = 0;
		pq.offer(new Edge(S,0));
		while(!pq.isEmpty()) {
			int cur;
			do {
				cur = pq.peek().end;
				pq.poll();
			}while(v[cur]&&!pq.isEmpty());
			
			if(v[cur]) break;
			
			for(Edge e:adj[cur]) {
				int next = e.end;
				if(dis[next] > dis[cur]+e.value) {
					System.out.println("dis["+next+"] > dis["+cur+"]+"+e.value);
					System.out.println(dis[next]+" "+(dis[cur]+e.value));
					System.out.println();
					dis[next] = Math.min(dis[next], dis[cur]+e.value);
					pq.offer(new Edge(next,dis[next]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] == INF)
				sb.append("INF").append("\n");
			else
				sb.append(dis[i]).append("\n");
		}

		System.out.println(sb.toString().trim());
	}
	public static class Edge implements Comparable<Edge>{
		int end;
		int value;
		public Edge(int e,int v) {
			this.end = e;
			this.value = v;
		}
		
		@Override
		public int compareTo(Edge o) {
			return value <= o.value ? -1 : 1;
		}
	}
}
