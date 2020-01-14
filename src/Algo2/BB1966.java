package Algo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BB1966 {
	static Queue<Dot> q;
	public static int find() {
		int max = 0;
		int qsize = q.size();
		for(int i=0;i<qsize;i++) {
			Dot dd = q.poll();
			int v = dd.pre;
			q.add(dd);
			if(max < v) {
				max = v;
			}
		}
		return max;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			q = new LinkedList<Dot>();
			for(int j=0;j<n;j++) {
				int pre = sc.nextInt();
				q.add(new Dot(pre,j));
			}
			int max = 0;
			int cnt = 0;
			int ans = 0;
			
			while(!q.isEmpty()) {
				max = find();
				Dot dot = q.poll();
				if(dot.pre < max) q.add(dot);
				else {
					cnt++;
					if(dot.idx == m) {
						ans=cnt;
					}
				}
			}
			System.out.println(ans);
		}
	
	}
	public static class Dot{
		int pre;
		int idx;
		public Dot(int p,int i) {
			this.pre = p;
			this.idx = i;
		}
	}
}
