package Algo4;

import java.util.Scanner;

public class B1916 {
	static int n,m,start,end;
	static int a[][];
	static int d[];
	static boolean v[];
	static final int INF = 1000000000;
	public static void solve() {
		int u;
		int dist;
		d[start] = 0;
		for(int i=1;i<=n;i++) {
			dist = INF+1;
			u = -1;
			for(int j=1;j<=n;j++) {
				if(!v[j] && d[j]<dist) {
					u=j;
					dist = d[j];
				}
			}
			for(int k=1;k<=n;k++) {
				if(d[k]>d[u]+a[u][k]) {
					d[k] = d[u] + a[u][k];
				}
			}
			v[u] = true;
		}
	} 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n+1][n+1];
		v = new boolean[n+1];
		d = new int[n+1];
		for(int i=1;i<=n;i++) {
			d[i] = INF;
			for(int j=1;j<=n;j++) {
				a[i][j] = INF;
			}
		}
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			
			if(a[v1][v2] > cost) {
				a[v1][v2] = cost;
			}
		}
		start = sc.nextInt();
		end = sc.nextInt();
		solve();
		System.out.println(d[end]);
		
		
	}
}
