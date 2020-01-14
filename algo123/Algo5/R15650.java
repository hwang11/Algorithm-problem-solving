package Algo5;

import java.util.LinkedList;
import java.util.Scanner;

public class R15650 {
	static int n,m;
	static LinkedList<Integer> li;
	public static void dfs(int s,int cnt) {
		if(li.size() == m) {
			for(int i=0;i<li.size();i++) {
				System.out.print(li.get(i)+" ");
			}
			System.out.println();
		}
		for(int i=s;i<=n;i++) {
			li.add(i);
			dfs(i+1,cnt+1);
			li.removeLast();
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		li = new LinkedList<Integer>();
		
		dfs(1,0);
	}
}
