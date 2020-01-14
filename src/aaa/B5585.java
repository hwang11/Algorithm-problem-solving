package aaa;

import java.util.Scanner;

public class B5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = 1000 - n;
		int a[] = { 500, 100, 50, 10, 5, 1 };
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (n == 0)
				break;
			while (n >= a[i]) {
				n -= a[i];
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
