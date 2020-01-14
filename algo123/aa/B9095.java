package aa;

import java.util.Scanner;

public class B9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int v = sc.nextInt();
			int a[] = new int[12];
			a[0] = 0;
			a[1] = 1;
			a[2] = 2;
			a[3] = 4;
			for(int j=4;j<=v;j++) {
				a[j] = a[j-1] + a[j-2] + a[j-3];
			}
			System.out.println(a[v]);
		}
	}
}
