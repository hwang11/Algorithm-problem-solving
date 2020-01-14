package Algo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class R2668 {
	static int n,last;
	static int a[];
	static boolean v[];
	static ArrayList<Integer> li;
	public static void dfs(int i) {
		if(!v[a[i]]) {
			v[a[i]] = true;
			dfs(a[i]);
			v[a[i]] = false;
		}
		if(last == a[i]) {
			li.add(last);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1];
		v = new boolean[n+1];
		li = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			v[i] = true;
			last = i;
			dfs(i);
			v[i] = false;
		}
		Collections.sort(li);
		System.out.println(li.size());
		
		for(int i : li) {
			System.out.println(i);
		}
		
	}
}
