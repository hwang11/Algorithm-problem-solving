package Expert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RRE5658 {
	static int ans,n,k,p,idx;
	static char arr[];
	static ArrayList<Integer> li = new ArrayList<Integer>();
	public static void solve() {
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i=0;i<arr.length;) {
				String sNum = "";
				idx = 0;
				while(idx!=p) {
					sNum+=arr[i++];
					idx++;
				}
				int v = getInt(sNum);
				if(!li.contains(v)) {
					li.add(v);
					flag = true;// 안끝났으면 계속 돌게.
				}
			}
			
			rotate();
		}
		
	}
	public static void rotate() {
		char Last = arr[arr.length-1];
		for(int i=(arr.length-1);i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = Last;
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
			p = n/4;
			idx = 0;
			arr = new char[s.length()];
			for(int i=0;i<s.length();i++) {
				arr[i] = s.charAt(i);
			}
			li.clear(); // 각 항목을  null로 설정.
			solve();
			Collections.sort(li);
			Collections.reverse(li);
			ans = li.get(k-1);
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
