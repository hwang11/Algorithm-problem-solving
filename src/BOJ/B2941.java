package han;
import java.util.Scanner;
public class B2941 {
	public static void main(String args[]) {
		String arr[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0;i<8;i++) {
			s = s.replace(arr[i], "a");
		}
		System.out.println(s.length());
	}
}
