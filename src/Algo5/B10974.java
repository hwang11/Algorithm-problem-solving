package Algo5;

import java.util.LinkedList;
import java.util.Scanner;

public class B10974 {
	static int n;
	static int a[];
	static boolean v[];
	static LinkedList<Integer> li;
	public static void dfs(int cnt) {
		if(cnt == n) {
			for(int j=0;j<li.size();j++) {
				if(v[li.get(j)]) {
					System.out.print(li.get(j)+" ");
				}
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			if(!v[i]) { //방문했으면 건너뛰도록 
				v[i] = true;
				li.add(i);
				dfs(cnt+1);
				v[i] = false;
				li.removeLast();
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		li = new LinkedList<Integer>();
		a = new int[n+1];
		v = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = i;
		}
		dfs(0);
		
	}
}
