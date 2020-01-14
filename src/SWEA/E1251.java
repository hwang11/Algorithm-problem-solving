package Expert;

import java.util.Scanner;

public class E1251 { //최소스패닝트리로 풀기.
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			int map[][] = new int[2][n];
			long ans;
			
			for(int i=0;i<2;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
		}
	}
}
