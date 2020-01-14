package Expert;

import java.util.Scanner;

public class E2072 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		String s = sc.next();
		for(int j=0;j<s.length();j++) {
			ans += s.charAt(j) - 48;
		}
		System.out.println(ans);
		
	}
}
