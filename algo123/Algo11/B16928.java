package Algo11;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class B16928 {
	static int a,b,now,cnt;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		now = 1;
		int max = 0;
		int next = 0;
		for(int i=0;i<a+b;i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			if(max < v) {
				max = v;
				next = k;
			}
		}
		int r = next - now;
		if(r%6 == 0) cnt += r/6;
		else cnt += (r/6) +1;
		now = max;
		
		int rr = 100 - now;
		if(rr%6 == 0) cnt += rr/6;
		else cnt += (rr/6) +1;

		System.out.println(cnt);
	}
}
