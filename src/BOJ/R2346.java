package Algo3;

import java.util.LinkedList;
import java.util.Scanner;

public class R2346 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Dot> li = new LinkedList<Dot>();
		for(int i=1;i<=n;i++) {
			int v = sc.nextInt();
			li.add(new Dot(i,v));
		}
		int now = 0; int val = 0;
		for(int i=0;i<n;i++) {
			if(val > 0) {
				for(int j=0;j<val-1;j++) {
					++now;
					if(now >= li.size()) {
						now = 0;
					}
				}
			}else if(val < 0) {
				val *=-1;
				for(int j=0;j<val;j++) {
					--now;
					if(now < 0) {
						now = li.size()-1;
					}
				}
			}
			Dot d = li.get(now);
			val = d.value;
			System.out.print(d.num+" ");
			li.remove(now);
			if(now == li.size()) {
				now = 0;
			}
			
		}
	}
	public static class Dot{
		int num;
		int value;
		Dot(int n,int v){
			this.num = n;
			this.value = v;
		}
	}
}
