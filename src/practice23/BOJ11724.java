package practice23;
import java.util.*;
public class BOJ11724 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = 1;
			a[v2][v2] = 1;
		}
		
		
	}
}
