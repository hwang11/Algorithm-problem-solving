package han;

import java.util.Scanner;

//42?
public class B2675 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int r = sc.nextInt();
			String s = sc.nextLine();
			for (int j = 1; j < s.length(); j++) {
				for (int i = 0; i < r; i++) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
