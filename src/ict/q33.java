package ict;

import java.util.ArrayList;
import java.util.List;

public class q33 {
	static int N;
	static boolean v[];
	static char arr[][];
	public static void dfs(int d) {
		v[d] = true;
		for(int i=0;i<N;i++) {
			if(arr[i][d] == '1' && arr[d][i] == '1' && !v[i]) {
				dfs(i);
			}
		}
	}
	
	public static int countGroups(List<String> related) {
		int cnt = 0;
		N = related.size();
		v = new boolean[N];
		arr = new char[N][N];
		for(int i=0;i<related.size();i++) {
			for(int j=0;j<related.get(i).length();j++) {
				arr[i][j] = related.get(i).charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			dfs(i);
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		List<String> a1 = new ArrayList<String>();
		a1.add("1100");
		a1.add("1110");
		a1.add("0110");
		a1.add("0001");
		
		List<String> a2 = new ArrayList<String>();
		a2.add("10000");	
		a2.add("01000");	
		a2.add("00100");	
		a2.add("00010");	
		a2.add("00001");	
		
		
		List<String> a3 = new ArrayList<String>();
		a3.add("110");
		a3.add("110");
		a3.add("001");
		
		/*답 6 
		 * 1000001000
0100010001
0010100000
0001000000
0010100000
0100010000
1000001000
0000000100
0000000010
0100000001
		 * 
		 * */
		List<String> a4 = new ArrayList<String>();
		a4.add("1000001000");
		a4.add("0100010001");
		a4.add("0010100000");
		a4.add("0001000000");
		a4.add("0010100000");
		a4.add("0100010000");
		a4.add("1000001000");
		a4.add("0000000100");
		a4.add("0000000010");
		a4.add("0100000001");

		

		System.out.println(countGroups(a1));
		System.out.println(countGroups(a2));
		System.out.println(countGroups(a3));
		System.out.println(countGroups(a4));
	}
}
