package ict;

import java.util.ArrayList;
import java.util.List;

public class q2 {
	public static void commonSubString(List<String> a, List<String> b) {
		for(int i=0;i<a.size();i++) {
			int a1[] = new int[26];
			int b1[] = new int[26];
			for(int j=0;j<a.get(i).length();j++) {
				String s = a.get(i);
				int idx = s.charAt(j) - 97;
				a1[idx] = 1;
			}
			for(int j=0;j<b.get(i).length();j++) {
				String s = b.get(i);
				int idx = s.charAt(j) - 97;
				b1[idx] = 1;
			}
			boolean flag = false;
			for(int k=0;k<a1.length;k++) {
				if(a1[k] == 1 && b1[k] == 1) flag = true;
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	public static void main(String[] args) {
		List<String> t1 = new ArrayList<String>();
		t1.add("hello");
		t1.add("ad");
		t1.add("c");
		
		List<String> t2 = new ArrayList<String>();
		t2.add("world");
		t2.add("dw");
		t2.add("d");
		
		commonSubString(t1,t2);
	}
}
