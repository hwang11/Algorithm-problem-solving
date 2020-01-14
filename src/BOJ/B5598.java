package han;

import java.util.Scanner;

public class B5598 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ')continue;
			int n = (s.charAt(i)-3);
			if(n<=64) n+=26;
			char c = (char)n;
			System.out.print(c);
		}
	}
}
