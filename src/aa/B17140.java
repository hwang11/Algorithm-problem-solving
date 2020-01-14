package aa;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B17140 {
	static int R,C,K,maxr,maxc,t;
	static int map[][];
	static int num[];
	static LinkedList<Integer> li;
	static PriorityQueue<Dot> pq;
	static void row() {
		for(int i=1;i<=maxr;i++) {
			li = new LinkedList<Integer>();
			pq = new PriorityQueue<Dot>();
			num = new int[101];
			for(int j=1;j<=maxc;j++) {
				int v = map[i][j];
				if(v ==0) continue;
				//System.out.println(v);
				num[v]++;
				if(!li.contains(v))  li.add(v);
				map[i][j] = 0;
			}
			for(int k=0;k<li.size();k++) {
				int n = li.get(k);
				int cnt = num[n];
				pq.add(new Dot(n,cnt));
			}
			int size = pq.size()*2;
			maxc = Math.max(size, maxc);
			for(int k=1;k<size;k+=2) {
				Dot dot = pq.poll();
				map[i][k] = dot.num;
				map[i][k+1] = dot.cnt;
			}
		}
	}
	static void col() {
		for(int i=1;i<=maxc;i++) {
			li = new LinkedList<Integer>();
			pq = new PriorityQueue<Dot>();
			num = new int[101];
			for(int j=1;j<=maxr;j++) {
				int v = map[j][i];
				if(v ==0) continue;
				num[v]++;
				if(!li.contains(v))  li.add(v);
				map[j][i] =0;
			}
			for(int k=0;k<li.size();k++) {
				int n = li.get(k);
				int cnt = num[n];
				pq.add(new Dot(n,cnt));
			}
			int size = pq.size()*2;
			maxr = Math.max(size, maxr);
			for(int k=1;k<size;k+=2) {
				Dot dot = pq.poll();
				map[k][i] = dot.num;
				map[k+1][i] = dot.cnt;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		map = new int[101][101];
		num = new int[101];
		maxr = 3;
		maxc = 3;
		t = 0;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while(true) {
			if(t>100) {
				t = -1;
				break;
			}
			if(map[R][C]==K) break;
			if(maxr >= maxc) {
				row();
			}else {
				col();
			}
			t++;
		}
		System.out.println(t);
	}
	static class Dot implements Comparable<Dot>{
		int num;
		int cnt;
		public Dot(int n,int c) {
			this.num = n;
			this.cnt = c;
		}
		
		@Override
		public int compareTo(Dot dot) {
			if(this.cnt > dot.cnt) return 1;
			else if(this.cnt < dot.cnt) return -1;
			else if(this.cnt == dot.cnt) {
				if(this.num < dot.num) return -1;
				else return 1;
			}
			return 0;
		}
	}
}
