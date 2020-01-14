package han;

import java.util.Arrays;
import java.util.Scanner;

//48- 51 1:59-2:08
public class B1316 {
	static boolean arr[];
	static boolean chk(String s) {
		for(int j=0;j<s.length();j++) {
			if(arr[s.charAt(j)-65]) {
				if(s.charAt(j) != s.charAt(j-1)) return false;
			}
			arr[s.charAt(j)-65] = true;
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		//그 단어 개수와 붙어있는 단어개수 비교? 
		String s1 = sc.nextLine();
		int cnt = 0;
		for(int i=0;i<N;i++) {
			String s = sc.nextLine();
			arr = new boolean[58];
			if(chk(s))cnt++;
		}
		System.out.println(cnt);
	}
}
