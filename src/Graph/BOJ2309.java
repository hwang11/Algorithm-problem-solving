package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			a[i] = sc.nextInt();
			sum+=a[i];
		}
		Arrays.sort(a);
		int d = sum-100;
		int index1 = 0;
		int index2 = 0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(a[j]+a[i]==d) {
					index1 = i;
					index2 = j;
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			if(index1 ==i || index2 == i) continue;
			System.out.println(a[i]);
		}
			
	}
}
