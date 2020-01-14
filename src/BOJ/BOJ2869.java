package practice20;
import java.util.*;
public class BOJ2869 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		long ans = 1000000000;
		int left = 0;
		int right = v / (a-b)+1;
		int day = 0;
		
		while(left <= right) {
			day = (left + right)/2;
			if(v <= day*(a-b)+a) {
				ans = Math.min(ans,day+1);
				right = day - 1;
			}
			else left = day + 1;
		}

		System.out.println(ans);
		
		
		
	}
}
