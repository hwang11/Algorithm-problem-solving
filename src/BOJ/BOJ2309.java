import java.util.*;
public class BOJ2309 {
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int a[]= new int[9];
		int sum = 0;
		int d = 0;
		int k = 0;
		int m = 0;
		for(int i=0;i<9;i++) {
			a[i]=scan.nextInt();
			sum += a[i];
		}
		d=sum-100;
		Arrays.sort(a);
		for(int i=0;i<9;i++) {
			for(int j=1;j<9;j++) {
				if(d==(a[i]+a[j])) {
					k=i;
					m=j;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(i!=k&&i!=m) {
				System.out.println(a[i]);
			}
		}
		
	}
}
