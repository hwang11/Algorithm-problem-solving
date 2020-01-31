package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
//LinkedList로 했다가 시간초과남 
public class B1766 {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int in[] = new int[N+1];
		ArrayList<Integer> li[] = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			li[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			in[b]++;
			li[a].add(b);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=1;i<=N;i++) {
			if(in[i]==0) pq.add(i);
		}
		while(!pq.isEmpty()) {
			int n = pq.poll();
			System.out.print(n+" ");
			for(int i=0;i<li[n].size();i++) {
				int next = li[n].get(i);
				in[next]--;
				if(in[next]==0) pq.add(next);
			}
		}
		
	}
}
