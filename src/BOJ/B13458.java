package BOJ;

import java.util.Scanner;

public class B13458 {
	static int n,b,c;
	static long sum;
	static int a[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		b = sc.nextInt();
		c = sc.nextInt();
		int b2;
		sum = 0;
		for(int i=0;i<n;i++) {
			b2 = b;
			a[i] -= b2;
			b2 = 0;
			sum++;
			if(a[i] <= 0) continue;
			if(a[i]>c) {
				if(a[i]%c == 0) sum += a[i]/c;
				else sum += (a[i]/c) +1;
				a[i] = 0;
			}
			else {
				a[i] -= c;
				sum++;
			}
		}
		System.out.println(sum);
	}
}
