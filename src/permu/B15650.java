package permu;

import java.util.LinkedList;
import java.util.Scanner;

public class B15650 {
	static int N,M;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static void dfs(int dep,int idx) {
		if(dep == M) {
			for(int i=0;i<li.size();i++) {
				System.out.print(li.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i=idx+1;i<=N;i++) {
			if(li.contains(i)) continue;
			li.add(i);
			dfs(dep+1,i);
			li.removeLast();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dfs(0,0);
	}
}
