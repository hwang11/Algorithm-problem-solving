package BOJ;

import java.util.Scanner;

public class BOJ13458 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
//		long n = sc.nextInt();
//		long a[] = new long[(int) n];
//		for(int i=0;i<n;i++) {
//			a[i] = sc.nextInt();
//		}
//		long b = sc.nextInt();//총감독 오직1명.
//		long c = sc.nextInt();//부감독 여러명 ok.
//		long sum = 0;
//		long cnt = 0;
//		for(int i=0;i<n;i++) {
//			if(a[i]>=b) {
//				sum += b;
//				cnt ++;
//			}
//			while(a[i]>sum) {
//				sum+=c;
//				cnt++;
//			}
//			sum = 0;
//		}
//		System.out.println(cnt);
		
		int n = sc.nextInt();
	    int[] array = new int[n];
	    long result = 0;
	 
	    for (int i = 0; i < n; i++) {
	        array[i] = sc.nextInt();
	    }
	 
	    int b = sc.nextInt();
	    int c = sc.nextInt();
	 
	    for (int i = 0; i < n; i++) {
	        result++;
	        array[i] -= b;
	 
	        if (array[i] > 0) {
	            result += Math.ceil(1.0 * array[i] / c); //반올림. overflow날까봐?
	        }
	 
	    }
	    System.out.println(result);

	}
}
