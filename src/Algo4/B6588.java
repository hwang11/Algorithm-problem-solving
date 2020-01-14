package Algo4;

import java.util.Scanner;

public class B6588 {
	static final int MAX = 1000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isprime[] = new boolean[MAX+1];
		boolean flag;
		for(int i=2;i<=MAX;i++) {
			isprime[i] = true;
		}
		for(int i=2;i*i<=MAX;i++) { //i는 1씩 2,3,4(x),5,,,
			if(!isprime[i]) continue;
			for(int j=i*2;j<=MAX;j+=i) { //j는 i만큼. 즉 i의 배수인 숫자는 모두 false처리.
				if(!isprime[j]) continue; //false이면 볼필요 X확인한곳은 더이상 돌지 않게.
				isprime[j] = false;
			}
		}
		
 		while(true) {
			int n = sc.nextInt();
			flag = false;

			if (n == 0) break;
			for(int i=2;i<=n/2;i++) {
				if(isprime[i] && isprime[n-i]) {
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
