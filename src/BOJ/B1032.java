package BOJ;

import java.util.HashMap;
import java.util.Scanner;

public class B1032 {
	static boolean v[];
	static void chk(String a,String b) {
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!=b.charAt(i)) v[i] = true;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s1 = sc.nextLine(); //앞에서 int로 사용했을 때 이렇게 빈공간 한번 추출..
		String arr[] = new String[n];
 		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLine();
		}
		v = new boolean[arr[0].length()];
 		for(int i=0;i<n-1;i++) {
 			for(int j=1;j<n;j++) {
 				chk(arr[i],arr[j]);
 			}
		}
 		String ans = "";
 		for(int i=0;i<arr[0].length();i++) {
 			if(v[i]) ans += "?";
 			else ans += arr[0].charAt(i);
 		}
 		System.out.println(ans);
	}
}
