package BOJ;
import java.util.*;
public class BOJ2251 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int asize = scan.nextInt();
		int bsize = scan.nextInt();
		int csize = scan.nextInt();
		
		int result[] = new int[200];
		int a,b,c;
		a = 0;
		b = 0;
		c = csize;
		
		for(int i=1;i<=csize;i++) {
			if(b==0&&a)
			a = i;
			c-=a;
			result[i]=c;
			
		}
		
		
		
		
	}
}
