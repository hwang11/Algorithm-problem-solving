package Expert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class E5658 {
	static int ans,n,k,p,max;
	static String arr[];
	static char ch[];
	static char tmp[];
	static int vv[];
	static int idx;
	static TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
	
	public static void move(String st,int cnt) {
		if(cnt ==p) {
			return;
		}
		for(int i=0;i<st.length()-1;i++) {
			tmp[i] = ch[i];
		}
		char tmp_idx = ch[st.length()-1];
		for(int i=0;i<st.length()-1;i++) {
			ch[i+1] = tmp[i];
		}
		ch[st.length()-1] = tmp[st.length()-2];
		ch[0] = tmp_idx;
		
		String ss = "";
		for(int i=0;i<st.length();i++) {
			ss+=ch[i];
		}
		check(ss);
		move(ss,cnt+1);
	}
	public static void check (String st) {
		//System.out.println("check: "+st);
		for(int i=0;i<4;i++) {
			arr[i]=st.substring(i*p, ((i+1)*p));
			//System.out.println("arr"+ arr[i]);
			long v = Long.parseLong(arr[i], 16);
			int value = Integer.parseInt(String.valueOf(v));
			map.put(value, 0);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			String s = sc.next();
			p = n/4;
			ans = 0;
			ch = new char[s.length()+1];
			tmp = new char[s.length()];
			arr = new String[4];
			vv = new int[100];
			idx = 0;
			
			for(int i=0;i<s.length();i++) {
				ch[i] = s.charAt(i);
				tmp[i] = s.charAt(i);
			}
			check(s);
			move(s,1);
			
			int num = 0;
			Iterator<Integer> keys = map.keySet().iterator();
	        while( keys.hasNext() ){
	            Integer key = keys.next();
	            vv[idx++] = key;
	            num++;
	        }

			ans = vv[num-k];
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
