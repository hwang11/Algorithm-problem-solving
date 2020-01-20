package BOJ;

import java.util.Scanner;

//2:11-2:16
public class B1152 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int cnt = 0;
		//공백의 개수 카운트 X 
		boolean flag = false;
		for(int i=0;i<s.length();i++) {
			if(!flag && s.charAt(i)!=' ') {
				cnt++;
				flag = true;
			}
			else if(s.charAt(i)==' ') flag = false;
		}
		System.out.println(cnt);
	}
}
