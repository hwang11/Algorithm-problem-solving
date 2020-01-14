package practice22;
import java.util.*;
public class BOJ7453 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][4];
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<4;j++) {
				arr[i][j] = sc.nextInt();
//				int v1 = sc.nextInt();
//				int v2 = sc.nextInt();
//				if(j<2) a[i] = v1 + v2;
//				else b[i] = v1 + v2;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j<2) a[i] = arr[i][0] + arr[j][1];
			}
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i]+b[j] == 0) count ++;
			}
		}
		System.out.println(count);
		
	}
}
