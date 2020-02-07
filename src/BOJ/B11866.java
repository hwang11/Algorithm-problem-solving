package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11866 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		LinkedList<Integer> li = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			li.add(i);
		}
		int now = 0;
		LinkedList li2 = new LinkedList<Integer>();
		while(!li.isEmpty()) {
			now += (k-1);
			now %= li.size();
			li2.add(li.get((now)));
			li.remove((now));
		}
		String s = "<";
		for(int i=0;i<li2.size()-1;i++) {
			s+= li2.get(i) + ", ";
		}
		s += li2.getLast() + ">";
		System.out.println(s);
	}
}
