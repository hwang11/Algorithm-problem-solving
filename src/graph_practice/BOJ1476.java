package graph_practice;

import java.util.Scanner;

public class BOJ1476 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		int e1 = 15;
		int s1 = 28;
		int m1 = 19;   
		int n = 1;
		while(true) {
			if((e%e1) == Math.floorMod(n, e1) && (s%s1) == Math.floorMod(n, s1) && (m%m1) == Math.floorMod(n, m1)) break;
			n++;
		}
		System.out.println(n);
	}
}
