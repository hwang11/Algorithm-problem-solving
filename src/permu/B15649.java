package permu;

import java.util.LinkedList;
import java.util.Scanner;

public class B15649 {
	static int N,M;
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static boolean v[];
	static void dfs(int dep) {
		if(dep == M) {
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
//			if(v[i]) continue;
//			v[i] = true;
			if(list.contains(i)) continue;
			list.add(i);
			dfs(dep+1);
			list.removeLast();
			//v[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		//v = new boolean[N+1];
		dfs(0);
	}
}
