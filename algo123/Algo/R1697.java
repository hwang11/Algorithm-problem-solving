package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class R1697 {
	static int N,K,cnt;
	static int MAX = 100001;
	static boolean v[];
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		v[N]=true;
		int nk = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int j=0;j<qsize;j++) {
				int n = q.poll();
				if(n == K) System.out.println(cnt);
				for(int i=0;i<3;i++) {
					if(i == 0) {
						nk = n+1;
					}else if(i == 1){
						nk = n-1;
					}else {
						nk = 2*n;
					}
					if(nk < 0|| v[nk] || MAX < nk) continue;
					v[nk] = true;
					q.add(nk);
				}
			}
			cnt++;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		v = new boolean[1000001];
		cnt = 0;
		bfs();
	}
}
