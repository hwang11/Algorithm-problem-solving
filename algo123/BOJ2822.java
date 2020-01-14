import java.util.*;
public class BOJ2822 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a[]=new int[8];
		int b[]=new int[8];
		int c[]=new int[8];
		int count=0;
		int sum=0;
		for(int i=0;i<8;i++) {
			a[i]=scan.nextInt();
			c[i]=a[i];
		}
		Arrays.sort(c);
		for(int j=7;j>2;j--) {
			sum+=c[j];
		}
		System.out.println(sum);
		
		for(int i=3;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(c[i]==a[j]) b[i]=(j+1);
			}
		}
		Arrays.sort(b);
		for(int i=3;i<8;i++) {
			System.out.print(b[i]+" ");
		}
		
		
		
		
		
		
		
	}
}
