package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B15650 {
	static int n,m;
	static LinkedList<Integer> li;
	public static void dfs(int d) {
		if(li.size() == m) {
			for(int j=0;j<li.size();j++) {
				System.out.print(li.get(j)+" ");
			}
			System.out.println();
		}
		
		for(int j=d;j<=n;j++) {
			li.add(j);
			dfs(j+1);
			li.removeLast();
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		li = new LinkedList<Integer>();
		dfs(1);
	}
}
