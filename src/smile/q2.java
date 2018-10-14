package smile;

import java.util.Scanner;

public class q2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int x =  sc.nextInt();
			if(x <= 0) System.out.println("음수.");
			else {
				int m = 0;
				int r = 0;
				while (x != 0)
			    {   
					r = x%10;
			        m+= r;
			        x/=10;
			    }
				
				if(x%m == 0) System.out.println("하샤드.");
				else System.out.println("하샤X");
			}
			
		}
		

	}
}
