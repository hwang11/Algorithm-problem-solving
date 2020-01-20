package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ14888 {
	static int n,cnt,sum;
	static int a[];
	
	static ArrayList<Integer> li = new ArrayList<Integer>();
	static ArrayList<Integer> li2 = new ArrayList<Integer>();
	public static void dfs(int v) {
		if(cnt == li.size()) {
			for(int i=0;i<li2.size();i++) {
				int k = li2.get(i);
				if(k == 0)  sum+=a[i+1];
				else if(k == 1) sum-=a[i+1];
				else if(k == 2) sum*=a[i+1];
				else sum /=a[i+1];
			}
		}
		else {
			for(int i=v+1;i<li.size();i++) {
				++cnt;
				li2.add(li.get(i));
				dfs(i);
				li2.remove(li2.size()-1);
			}
		}
		--cnt;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			int v = sc.nextInt();
			for(int j=0;j<v;j++) {
				li.add(i);
			}
		}
		cnt = 1;
		sum = a[0];
		dfs(0);
		
		System.out.println(sum);
	}
}
