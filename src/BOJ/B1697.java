package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {
	static int n,k;
	static int MAX = 100001;
	static boolean v[];
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		v[n] = true;
		int nk = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int j=0;j<qsize;j++) {
				int kk = q.poll();
				if(kk == k) System.out.println(cnt);
				for(int i=0;i<3;i++) {
					if(i==0) {
						nk=kk+1;
					}
					else if(i==1) {
						nk=kk-1;
					}
					else {
						nk=2*kk;
					}
					if(nk < 0 || nk > MAX || v[nk]) continue;
					v[nk] = true;
					q.add(nk);
				}
				
			}
			cnt++;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		v = new boolean[1000001];
		bfs();
		
	}
}
