package practice26;

import java.util.Scanner;

public class BOJ1208 {
	static int arr[];
	static int a[] = new int[4000001];
	static long cnt;
	static int n;
	static int s;
	public static void f(int p,int t,boolean c) {
		if(p==n/2) {
			if(c == false) return;
			if(t == s) cnt++;
			a[t+2000000]++;
			return;
		}
		f(p+1,t+arr[p],true);
		f(p+1,t,c);
	}
	public static void g(int p,int t,boolean c) {
		if(p==n) {
			if(c==false) return;
			if(t == s) cnt++;
			if(s-t>2000000 || s - t <-2000000) return;
			cnt += a[s-t+2000000];
			return;
		}
		g(p+1,t+arr[p],true);
		g(p+1,t,c);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		f(0,0,false);
		g(n/2,0,false);
		System.out.println("cnt"+cnt);
		
	}
}
