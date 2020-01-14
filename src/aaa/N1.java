package aaa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class N1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a[] = new String[n];
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		Iterator<String> keys = map.keySet().iterator();
		int max = 0;
		while (keys.hasNext()) {
			String key = keys.next();
			int v = map.get(key);
			max = Math.max(v, max);
		}
		Iterator<String> keys2 = map.keySet().iterator();
		int cnt = 0;
		while (keys2.hasNext()) {
			String key = keys2.next();
			int v = map.get(key);
			if(v<max) cnt++;
		}
		boolean flag = false;
		boolean ch = false;
		if(cnt > 1) {
			flag = false;
			ch = false;
		}else if(cnt == 1) {
			flag = true;
			ch = true;
		}else {
			flag = true;
			ch = false;
		}
		
		if(flag) System.out.println("Y");
		else System.out.println("N");
		if(ch) System.out.println(n+1);
		else System.out.println(n);
		System.out.println(map.size());

	}
}
