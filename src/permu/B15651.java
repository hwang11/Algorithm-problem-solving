package permu;

import java.util.LinkedList;
import java.util.Scanner;

public class B15651 {
	static int N,M;
	static StringBuilder sb;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static void dfs(int dep) {
		if(dep == M) {
			for(int i=0;i<li.size();i++) {
				sb.append(li.get(i)+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=N;i++) {
			li.add(i);
			dfs(dep+1);
			li.removeLast();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb);
	}
}

