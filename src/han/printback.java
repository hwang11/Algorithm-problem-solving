package han;

import java.util.Scanner;

public class printback {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s);
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)==' ') continue;
			System.out.print(s.charAt(i));
		}
	}
}
