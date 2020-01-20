package BOJ;

import java.util.Scanner;

public class B14888 {
	static int n;
	static int num[];
	static int a[];
	static int max,min;
	public static void solve(int sum,int idx) {
		if(idx == n) { 
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}
		for(int i=0;i<4;i++) {
			if(a[i]==0) continue;
			a[i]--;
			if(i == 0) {
				solve(sum+num[idx],idx+1);
			}
			if(i == 1) {
				solve(sum-num[idx],idx+1);
			}
			if(i == 2) {
				solve(sum*num[idx],idx+1);
			}
			if(i == 3) {
				solve(sum/num[idx],idx+1);
			}
			a[i]++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		a = new int[4];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			a[i] = sc.nextInt();
		}
		max = -1000000000; //범위가 -10억에서 10억까지 이므로 
		min = 1000000000;
		solve(num[0],1);
		System.out.println(max);
		System.out.println(min);
	}
}
