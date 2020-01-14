package practice20;
import java.util.*;
public class BOJ10815 {
	static int n;
	static int m;
	static int a1[];
	static int a2[];
	public static void search(int x) {
		int left = 0;
		int right = n - 1;
		int mid = 0;
		while(left<=right) {
			mid = (left + right) / 2;
			if(x < a1[mid]) right = mid - 1;
			else if(x > a1[mid]) left = mid + 1;
			else {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
		return;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a1 = new int[n];
		
		for(int i=0;i<n;i++) {
			a1[i] = sc.nextInt();
		}
		Arrays.sort(a1);
		
		m = sc.nextInt();
		a2 = new int[m];
		int ans[] = new int[m];
		for(int j=0;j<m;j++) {
			a2[j] = sc.nextInt();
			search(a2[j]);
		}
		
		
		
		
	}
}
