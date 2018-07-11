package practice20;
import java.util.*;
public class BOJ1654 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextInt();
		long n = sc.nextInt();
		long a[] = new long[(int) k];
		for(int i=0;i<k;i++) {
			a[i] = sc.nextInt();
		}
		long left = 1;
		long right = (long) (Math.pow(2,31)-1);
		long mid = 0;
		long cnt = 0;
		long ans = 0;
		
		while(left<=right) {
			mid = (left + right)/2;
			cnt = 0;
			for(int i=0;i<k;i++) {
				cnt+=a[i]/mid;
			}
			if(n<=cnt) { //개수가 더 많으면 길이를 늘려야함.
				left = mid + 1;
				ans = mid;
			}
			else { //개수가 더 적으면 길이를 줄여야함.
				right = mid - 1;
			}
			
		}
		System.out.println(ans);
		
	}
}
