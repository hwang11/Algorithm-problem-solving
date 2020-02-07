package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B2660 {
	static int n;
	static int a[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i == j) continue;
				a[i][j] = 100;
			}
		}
		while(true) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1 == -1) break;
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}

		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(a[i][j] > a[i][k]+a[k][j]) {
						a[i][j] = a[i][k]+a[k][j];
					}
				}
			}
		}
		
		int max[] = new int[n+1];
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i][j] == 0) continue;
				if(i == j) continue;
				max[i] = Math.max(max[i], a[i][j]);
			}
			if(min > max[i]) {
				min = max[i];
			}
		}

		LinkedList<Integer> list = new LinkedList<Integer>(); 
		for(int i=1;i<=n;i++) {
			if(min == max[i]) {
				list.add(i);
			}
		}
		System.out.print(min+" ");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
