package practice23;
import java.util.*;
public class BOJ2033 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = 1;
		while(n>t*10) {
			n+=5*t;
			t*=10;
			n-=n%t;
		}
		System.out.println(n);
//		double l = n.length();
//		double k = Math.pow(10, l-1);
//		double r = Math.round(Double.parseDouble(n)/k);
//		double ans = r * k;
//		System.out.println((int)ans);

	}
}
