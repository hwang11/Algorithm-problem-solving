package BOJ;
import java.util.*;

public class BOJ13241 {
    public long gcd(long a,long b) {
        if(a==0)
            return b;
        else
            return gcd(b%a,a);      
    }
    public long lcm(long a,long b) {
        return a*b/gcd(a,b);        
    }   
	public static void main(String args[]) {
		BOJ13241 bo = new BOJ13241();
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		System.out.println(bo.lcm(a,b));
		
	}
}

