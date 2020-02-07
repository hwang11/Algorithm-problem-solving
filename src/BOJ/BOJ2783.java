package BOJ;
import java.text.DecimalFormat;
import java.util.*;
public class BOJ2783 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		float x1 = sc.nextInt();
		float y1 = sc.nextInt();
		int n = sc.nextInt();
		float a = 0; 
		float b = 0;
		float f = x1/y1;
		for(int i=0;i<n;i++) {
			a = sc.nextFloat();
			b = sc.nextFloat();
			f = f < a / b ? f : a / b;
		}
		System.out.println(f*1000);
		//float a[][] = new float[n+1][2];
//		double b[] = new double[n+1];
//		a[n][0] = x1;
//		a[n][1] = y1;
//		double z=0;
//		for(int i=0;i<n;i++) {
//			a[i][0] = sc.nextInt();
//			a[i][1] = sc.nextInt();
//			z = 1000 / a[i][1];
//			b[i]=(double)z*a[i][0];
//		}
//		a[n][0] = x1;
//		a[n][1] = y1;
//		z = 1000 / a[n][1];
//		b[n]=z*a[n][0];
//		Arrays.sort(b);
//		DecimalFormat form = new DecimalFormat("#.00");
//	    float dNumber = (float)b[0];
//	    System.out.println(form.format(dNumber)); 



		
	}
}
