package Algo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1389 {
	static int n,m;
	static int a[][];
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n+1][n+1];
		boolean v[][] = new boolean[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}
		int min = Integer.MAX_VALUE; 
		int ans = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			q.add(i);
			v[i][i] = true;
			
			int tmp = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int j=1;j<=n;j++) {
					if(!v[i][j] && a[now][j]==1) {
						q.add(j);
						a[i][j] = a[i][now] + a[now][j];
						v[i][j] = true;
						tmp += a[i][j];
					}
				}
			}
			
			if(tmp < min) {
				min = tmp;
				ans = i;
			}
		}
		System.out.println(ans);

		
	}
}
