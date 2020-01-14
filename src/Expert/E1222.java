package Expert;

import java.util.Scanner;

public class E1222 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int len = sc.nextInt();
			int sum = 0;
			String s = sc.next();
			for(int j=0;j<s.length();j++) {
				if(j%2==0) {
					sum+=(s.charAt(j)-48);
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}
