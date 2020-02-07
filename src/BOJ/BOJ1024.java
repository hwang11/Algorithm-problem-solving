package BOJ;
import java.util.*;
public class BOJ1024 {
	int sum(int n) {
		return n*(n+1)/2;
		
	}
	void show(int n,int l) {
		for(int i=n;i<n+l;i++) {
			System.out.println(i);
		}
	}
	public static void main(String args[]) {
		BOJ1024 b = new BOJ1024();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int x = -1;
		for(int i=l;i<100;i++) {
			if( (((n-b.sum(n-1))/l)>=0) && (((n-b.sum(n-1))%l) == 0) ){
				x = (n-b.sum(l-1))/l;
	            b.show(x, l);
			}
			l++;
		}
		if(n>100||)
	    System.out.println("-1");
	}
}
