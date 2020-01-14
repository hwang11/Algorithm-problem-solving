import java.util.Scanner;

public class Calc {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String e = sc.next();
			if(e.equals("+"))System.out.println(a+b);
			else if(e.equals("-")) System.out.println(a-b);
			else if(e.equals("*")) System.out.println(a*b);
			else System.out.println(a/b);
		}
	}
}
