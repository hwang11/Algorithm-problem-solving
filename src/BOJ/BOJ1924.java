package BOJ;
import java.util.*;
public class BOJ1924 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		String arr[]={"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int all=0;
		int j=0;
		for(int i=1;i<x;i++) {
			if(i==4||i==6||i==9||i==11) {
				all+=30;
			}
			else if(i==2) {
				all+=28;
			}
			else {
				all+=31;
			}
		}
		all+=y;
		j=(all%7);
		System.out.println(arr[j]);
		
		
		
	}
}
