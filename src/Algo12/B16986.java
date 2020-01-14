package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class B16986 {
	static int N,K,t,ans;
	static int map[][];
	static int a1[],a2[],a3[];
	static boolean v[];
	static Per p1,p2,p3;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static void win(Per a,Per b) {
		if(map[a.idx][b.idx]>2) { //지우이김 
			a.cnt++;
		}
		else if(map[a.idx][b.idx] == 0) { //경희 이김 
			b.cnt++;
		}
		else {
			b.cnt++;
		}
	}
	static void solve() {
		int j = 0;
		while(true) {
			if(li.isEmpty()) return;
			if(p1.cnt >= K || p2.cnt >= K|| p3.cnt >= K) {
				ans = p1.idx;
				return;
			}
			chk(a[li.get(t)],)
			t++;
		}
	}
	static void dfs(int cnt) {
		if(cnt == N) {
			solve();
		}
		for(int i=0;i<3;i++) {
			if(v[i]) continue;
			v[i] = true;
			li.add(i);
			dfs(i+1);
			v[i] = false;
			li.removeLast();
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][N+1];
		v = new boolean[3];
		a1 = new int[N];
		a2 = new int[20];
		a3 = new int[20];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<20;i++) {
			a2[i] = sc.nextInt();
		}
		for(int i=0;i<20;i++) {
			a3[i] = sc.nextInt();
		}
		dfs(0);
		if(ans == 0) System.out.println(1);
		else System.out.println(0);
	}
	static class Per{
		int idx;
		int num;
		int cnt;
	}
	
}
