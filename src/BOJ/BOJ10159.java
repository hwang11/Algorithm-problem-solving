package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10159 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n+1][n+1];
		boolean v[] = new boolean[n+1];
		int c[] = new int[n+1];
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty()) {
			int vv = q.poll();
			for(int i=1;i<=n;i++) {
				if(a[vv][i] == 1 && v[i] == false) {
					q.add(i);
					v[i] = true;
					c[vv]++; 
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.println(n - c[i]);
		}
		
	}
}
