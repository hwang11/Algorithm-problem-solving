package smile;

import java.util.Scanner;

public class q1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = 1;
		for(int i=0;i<t;i++) {
			int x = sc.nextInt();
			while(k*k<x) {
				k++;
			}
			if(k*k == x) {
				System.out.println((k+1)*(k+1));
			}
			else {
				System.out.println("-1");
			}
		}

	}
}
