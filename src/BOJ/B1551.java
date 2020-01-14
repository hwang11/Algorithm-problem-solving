package Algo7;

import java.util.Arrays;
import java.util.Scanner;

public class B1551 {
	static int N,K;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int a[] = new int[N];
		String t = sc.next();
		String[] array = t.split(",");
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(array[i]);
		}
		int cnt = 0;
		while(cnt<K) {
			for(int i=0;i<a.length-1;i++) {
				a[i] = a[i+1]-a[i];
			}
			cnt++;
		}
		for(int i=0;i<N-K;i++) {
			if(i == N-K-1) System.out.print(a[i]);
			else System.out.print(a[i]+",");
		}
	}
}
