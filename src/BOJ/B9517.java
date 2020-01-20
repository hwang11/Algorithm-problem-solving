package BOJ;

import java.util.Scanner;

public class B9517 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int pos;
		int sum = 0;
		pos = k;
		while(n>0) {
			int t = sc.nextInt();
			String s = sc.next();
			sum+=t;
			if(210<=sum) break;
			if(s.equals("T")) {
				pos++;
			}
			if(pos>8) pos%=8;
			
			n--;
		}
		System.out.println(pos);
		
	}

}
