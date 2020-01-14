import java.util.*;
public class Main {
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		a/=100;
		a*=100;
		for(int i=0;i<=100;i++) {
			if((a+i)%b==0) {
				System.out.println((a+i)%100);
			}
		}
	}
}
