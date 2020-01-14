package han;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class B1764 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String s1 = sc.nextLine();
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			map.put(s, 0);
		}
		LinkedList<String> li = new LinkedList<String>();
		for(int i=0;i<m;i++) {
			String s = sc.nextLine();
			if(map.containsKey(s)) li.add(s);
		}
		String arr[] = new String[li.size()];
		System.out.println(li.size());
		for(int i=0;i<li.size();i++) arr[i] = li.get(i);
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) if(arr[i]!=null) System.out.println(arr[i]);
	}
}
