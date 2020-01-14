package practice10;
import java.util.*;
public class BOJ12790 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int sum=0;
		int a[]= new int[8];
		while(true) {
			if(t==0) break;
			for(int i=0;i<8;i++) {
				a[i] = sc.nextInt();
				if(i>3) a[i-4] += a[i];
			}
			if(a[2]<0) a[2]=0;
		    if (a[0] < 1) a[0] = 1;
	        if (a[1] < 1) a[1] = 1;
	        sum = a[0] +5 * a[1] + 2*a[2] + 2*a[3];
			System.out.println(sum);
			t--;
		}
		
	}
}