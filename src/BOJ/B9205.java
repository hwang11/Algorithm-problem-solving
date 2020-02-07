package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B9205 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		LinkedList<Dot> li = new LinkedList<Dot>();
		for(int tc = 1;tc<=t;tc++) {
			int n = sc.nextInt();
			for(int i=0;i<n+2;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				li.add(new Dot(x,y));
			}
			boolean flag = false;
			int cnt = 0;
			
			for(int i=0;i<li.size()-1;i++) {
				int sum = Math.abs((li.get(i).x-li.get(i+1).x)+(li.get(i).y-li.get(i+1).y));
				sum /=50;
				if(20>=sum) {
					cnt++;
				}
			}
			if(cnt == li.size()-1) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
