package BOJ;

import java.util.Scanner;

public class R6588 {
	public static final int MAX = 1000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isprime[] = new boolean[MAX+1];
		for(int i=2;i<=MAX;i++) {
			isprime[i] = true;
		}
		for(int i=2;i*i<=MAX;i++) {
			if(!isprime[i]) continue;
			for(int j=i*2;j<=MAX;j+=i) {
				if(!isprime[j]) continue;
				isprime[j] = false;
			}
		}
		
		while(true) {
			
			int n = sc.nextInt();
			if(n == 0) break;
			boolean flag = false;
			
			for(int i=2;i<=n/2;i++) {
				if(isprime[i]&&isprime[n-i]) {
					System.out.printf("%d = %d + %d\n",n,i,n-i);
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
