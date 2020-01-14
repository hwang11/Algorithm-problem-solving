package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class B15684 {
	static int N,M,H,ans,num;
	static boolean v[];
	//static int map[][];
	static LinkedList<Integer> li[];
	public static void count() {
		num = 0;
		for(int i=1;i<=H;i++) {
			if(li[i].size()%2 != 0) num++;
		}
	}
	static boolean check() {
		for(int i=1;i<M-1;i++) {
			for(int j=0;j<li[i].size()-1;j++) {
				if(li[i+1].size()-1 <= j) continue;
				if(li[i].get(j) < li[i+1].get(j)) {
					if(li[i].get(j+1) < li[i+1].get(j+1)) return false;
				}
				else {
					if(li[i].get(j+1) > li[i+1].get(j+1)) return false;
				}
			}
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		//map = new int[H+1][N+1];
		li = new LinkedList[H+1];
		for(int i=1;i<=H;i++) {
			li[i] = new LinkedList<Integer>();
		}
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			li[b].add(a);
		}
		//짝수개수 세기 
		count();
		ans = num;
//		System.out.println(check());
//		System.out.println(num);
//		System.out.println(check());
		if(ans>3 || !check()) ans = -1;
		System.out.println(ans);
	}
}
