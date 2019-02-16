package Algo2;

import java.util.LinkedList;
import java.util.Scanner;

public class T1158 {
	static int n,m;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a[] = new int[n];
		LinkedList<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		int idx = 0;

		int qsize = q.size();
		for(int i=0;i<n;i++) {
			idx += (m-1);
			if(idx > qsize) {
				idx %= qsize;
			}
			System.out.println(idx);
			System.out.println("q"+qsize);
			a[i] = q.get(idx);
			q.remove(idx);
			qsize = q.size();

		}
		System.out.print("<");

		for(int i=0;i<n;i++) {
			if(i==n-1) {
				System.out.print(a[i]);
			}
			else System.out.print(a[i]+", ");
			
		}
		System.out.println(">");
	}
}
