package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1068 {
	static int a[][];
	static boolean visited[];
	static int n;
	static int count;
	static int ans;
//	public static void bfs(int x) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(x);
//		while(!q.isEmpty()) {
//			int t = q.poll();
//			count = 0;
//			for(int i=0;i<n;i++) {
//				if(a[t][i] == a[i][t] && 0!=a[i][t] && visited[i] == false) {
//					q.add(i);
//					visited[i] = true;
// 				}
//				else {
//					count++;
//				}
//				if(count == n) {
//					ans++;
//				}
//			}
//		}
//	}
	public static void dfs(int root) {
		int ch = 0;
		for(int i=0;i<n;i++) {
			if(a[root][i] ==1) {
				dfs(i);
				ch = 1;
			}
		}
		if(ch == 0) ans++;
		return;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		int start = 0;
		count = 0;
		ans = 0 ;
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			int v = sc.nextInt();
			if(v == -1) {
				start = i;
				continue;
			}
 			a[v][i] = 1;
			a[i][v] = 1;
		}
		int r = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i][r] = 0;
			a[r][i] = 0;
		}
//		Arrays.fill(visited, false);
//		visited[0] = true;
//		bfs(0);
		if(start !=r) {
			dfs(start);
		}
		System.out.println(ans);
		
	}
}
