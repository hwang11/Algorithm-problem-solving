import java.util.*;
public class Alarm {
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();
		boolean a = false;
		if(0 <= h && h <= 23 && 0 <= m && m <= 59) {
			if (m < 45) {
				m += 15;
				a = true;
			}
			else m -= 45;
			if (a) {
				if(h==0) h=23;
				else h -= 1;
			}
			System.out.println(h+" "+m);	
		}
	}
}
