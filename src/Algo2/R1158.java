package Algo2;

import java.util.LinkedList;
import java.util.Scanner;

public class R1158 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer> q = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=n;i++) q.add(i);
		int idx = 0;
		int qsize = q.size();
		int a[] = new int[n];
		
		for(int i=0;i<n;i++) {
			idx+=(m-1);
			idx%=qsize;
			a[i] = q.get(idx);
			q.remove(idx);
			qsize--;
		}
		sb.append("<");
		for(int i=0;i<n;i++) {
			if(i==n-1) sb.append(a[i]);
			else sb.append(a[i]+", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}
