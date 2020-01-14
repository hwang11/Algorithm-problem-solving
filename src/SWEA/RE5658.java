package Expert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RE5658 {
	static int n,k,p,ans;
	static char[] arr;
	static List<Integer> list = new ArrayList<Integer>();
	public static void solve() {
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i=0;i<arr.length;) {
				int idx = 0;
				String sNum = "";
				while(idx!=p) { //p개씩 끊는 과정.
					sNum += arr[i++];
					idx++;
				}
				int t = getInt(sNum);
				if(!list.contains(t)) { //중복검사.
					list.add(t);
					flag = true;
				}
			}
			rotate();		
		}
	}
	public static void rotate() {
		char lastN = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = lastN;
	}
	public static int getInt(String s) {
		return Integer.parseInt(s,16);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			String s = sc.next();
			arr = new char[s.length()];
			for(int i=0;i<s.length();i++) {
				arr[i] = s.charAt(i);
			}
			p = s.length()/4;
			ans = 0;
			list.clear();
			
			solve();
			
			Collections.sort(list);
			Collections.reverse(list);
			ans = list.get(k-1);
			System.out.println("#"+t+" "+ans);
		}
	}

}
