package practice18;
import java.util.*;

public class BOJ2851 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[10];
		int ans = 0; 
		for(int i=0;i<10;i++) {
			a[i]=sc.nextInt();
			if(Math.abs(ans)>=Math.abs(ans+a[i])) {
				System.out.println(ans);
				break;
			}
			ans += a[i];
		}
}
}