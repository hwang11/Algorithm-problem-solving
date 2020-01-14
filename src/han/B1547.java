package han;

import java.util.LinkedList;
import java.util.Scanner;

public class B1547 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(0);
		li.add(1);
		li.add(2);
		li.add(3);
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int a1,a2;
			a1 = li.indexOf(v1);
			a2 = li.indexOf(v2);
			li.set(a2, v1);
			li.set(a1, v2);
			
		}
		System.out.println(li.get(1));	
	}
}
