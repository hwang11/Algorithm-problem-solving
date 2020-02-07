
package BOJ;

import java.util.Scanner;
//단위행렬 
public class dan {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) System.out.print(1 );
				else System.out.print(0 );
			}
			System.out.println(); 
		}
	}
}
