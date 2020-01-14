package Algo5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B1759 {
	static int L,C;
	static String a[];
	static LinkedList<String> li;
	public static void dfs(int d,int j,int m) {
		if(li.size() == L) {
			if(j<2 || m <1) return;
			for(int i=0;i<li.size();i++) {
				System.out.print(li.get(i));
			}
			System.out.println();
		}
		for(int i=d;i<C;i++) {
			li.add(a[i]);
			if(a[i].equals("a") || a[i].equals("e") 
					|| a[i].equals("i") || a[i].equals("o") || a[i].equals("u")) {
				dfs(i+1,j,m+1);
			}
			else dfs(i+1,j+1,m);
			li.removeLast();
		}
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		a = new String[C];
		for(int i=0;i<C;i++) {
			String s = sc.next();
			a[i] = s;
		}
		Arrays.sort(a);
		li = new LinkedList<String>();

		dfs(0,0,0);
	}
}
