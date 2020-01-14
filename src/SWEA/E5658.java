package Asamsung;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class E5658 {
	static int N,K,R,ans;
	static LinkedList<String> li; 
	static TreeSet<Integer> set;
	static void rot() {
		for(int i=0;i<4;i++) {
			String s ="";
			int p = i*R;
			for(int j=p;j<p+R;j++) {
				s += li.get(j);
			}
			int num = Integer.parseInt(s,16);
			set.add(num);
		}
		li.addFirst(li.getLast());
		li.removeLast();
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			li = new LinkedList<String>();
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			for(int i=0;i<s2.length();i++) li.add(s2.substring(i, i+1));
			R = N/4;
			set = new TreeSet<Integer>();
			for(int i=0;i<R+1;i++) rot();
			int size = set.size();
			int arr[] = new int[size];
			int idx = 0;
			Iterator it = set.iterator();
			while(it.hasNext()) {
				arr[idx++] = (int) it.next();
			}
			System.out.printf("#%d %d\n",tc,arr[size-K]);
		}
	}
}
