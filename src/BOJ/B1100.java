package han;

import java.util.Scanner;

public class B1100 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		for(int i=0;i<8;i++) {
			String s = sc.nextLine();
			for(int j=0;j<s.length();j++) {
				if(i%2==0 && j%2==0 && s.charAt(j)=='F') cnt++;
				else if(i%2!=0 && j%2!=0 && s.charAt(j)=='F') cnt++;
			}
		}
		System.out.println(cnt);
	}
}
