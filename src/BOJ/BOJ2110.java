package BOJ;
//공유기설치.
import java.util.*;
public class BOJ2110 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		int d = 0;
		int left = 1;
		int right = a[n-1] - a[0];
		int ans = 0;
		
		while(left<=right) {
			int start = a[0];
			int mid = (left + right)/2;
			int cnt = 1;
			for(int i=1;i<n;i++) {
				d = a[i] - start;
				if(mid <= d) {
					start = a[i];
					cnt++;
				}
			}
			if(cnt>=c) {
				ans = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
			
			
		}
		System.out.println(ans);

	}
}
