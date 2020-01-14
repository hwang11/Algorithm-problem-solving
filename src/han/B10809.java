package han;

import java.util.Scanner;

public class B10809 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		//String s1 = sc.nextLine();
		String s = sc.nextLine();
		String al = "abcdefghijklmnopqrstuvwxyz";
		boolean flag = false;
		for(int i=0;i<al.length();i++) {
			flag = false;
			for(int j=0;j<s.length();j++) {
				if(al.charAt(i) == s.charAt(j)) {
					System.out.print(j+" ");
					flag = true;
					break;
				}
				else continue;
			}
			if(!flag) System.out.print("-1 ");
		}
		
	}
}
