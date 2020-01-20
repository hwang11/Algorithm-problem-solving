package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B15649 {
	static int n,m;
	static LinkedList<Integer> li;
	static boolean v[];
	
	public static void dfs(int cnt) {
		if(cnt == m) {
			for(int i=0;i<li.size();i++) {
				if(v[li.get(i)]) {
					System.out.print(li.get(i)+" ");
				}
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			if(!v[i]) {
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
		m = sc.nextInt();
		li = new LinkedList<Integer>();
		v = new boolean[n+1];
		dfs(0);
	}
}
