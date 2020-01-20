package BOJ;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B2668 {
	static int n,last;
	static int a[];
	static boolean v[];
	static List<Integer> li = new LinkedList<Integer>();
	public static void dfs(int i) {
		if(!v[a[i]]) {
			v[a[i]] = true;
			System.out.println("2번째 dfs("+a[i]+")호출 last:"+last);
			dfs(a[i]);
			System.out.println(a[i]+"false");
			v[a[i]] = false;
		}
		if(a[i] == last) { //사이클 확인.
			System.out.println("list 추가: "+last);
			li.add(last);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1];
		v = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++){
			v[i] = true;
			last = i;
			System.out.println("dfs("+i+")호출 last:"+last);
			dfs(i);
			v[i] = false;
			System.out.println(i+"false");

		}
		Collections.sort(li);
		System.out.println(li.size());
		for(int i : li) {
			System.out.println(i);
		}
		
	}
}
