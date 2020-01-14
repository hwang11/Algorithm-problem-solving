package han;

import java.util.Scanner;

public class B10988 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length()/2;
		boolean flag = false;
		for(int i=0;i<n;i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				flag = true;
				break;
			}
		}
		if(flag) System.out.println(0);
		else System.out.println(1);
//		int a[] = {1,2,3};
//		for(int t : a) { //t는 index가아니라 value
//			System.out.println(t);
//		}
	}
}
