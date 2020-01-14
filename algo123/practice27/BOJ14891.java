package practice27;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ14891 {
	static LinkedList<Integer>[] list = (LinkedList<Integer>[]) new LinkedList[5];
	
	public static void rotate(int n,int dr) {
		if(dr == 1) list[n].addFirst(list[n].pollLast());
		else list[n].addLast(list[n].peekFirst());
	}
	public static void left(int n,int dr) {
		if(!(n>=1 && n<=4)) return;
		if(check(n,n+1)) {
			left(n-1,-dr);
			rotate(n,dr);
		}
	}
	public static void right(int n,int dr) {
		if(!(n>=1 && n<=4)) return;
		if(check(n,n-1)) {
			right(n+1,-dr);
			rotate(n,dr);
		}
	}
	public static boolean check(int a,int b) {
		if(a>b) {
			if(list[a].get(6) == list[b].get(2)) return false;
			else return true;
		}
		else {
			if(list[a].get(2) == list[b].get(6)) return false;
			else return true;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=4;i++) {
			String s = sc.next();
			list[i] = new LinkedList<Integer>();
			for(int j=0;j<8;j++) {
				list[i].add(s.charAt(j)-48);
			}
		}
		int k = sc.nextInt();
		for(int i=0;i<k;i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			
			left(n-1,d);
			right(n+1,d);
			rotate(n,d);
		}
		int ans = 0;
		for(int i=1;i<=4;i++) {
			if(list[i].get(0) == 1) ans+=Math.pow(2, (i-1));
		}
		System.out.println(ans);
		
	}
	
}
