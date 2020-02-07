package Expert;

import java.util.LinkedList;
import java.util.Scanner;

public class EE1248 {
	static int n,min,sum,x1,x2,y1,y2;
	static LinkedList<Dot> li;
	public static void solve(int cnt,int before,int sum) {
		if(cnt == n) {
			int x = li.get(before).x;
			int y = li.get(before).y;
			int hx = li.get(1).x;
			int hy = li.get(1).y;
			sum += (Math.abs(hx-x) + Math.abs(hy-y));
			min = Math.min(min, sum);
			return;
		}
		for(int i=2;i<li.size();i++) {
			if(!li.get(i).v) {
				x1 = li.get(before).x;
				y1 = li.get(before).y;
				x2 = li.get(i).x;
				y2 = li.get(i).y;
				li.get(i).v = true;
				solve(cnt+1,i,sum+(Math.abs(x1-x2) + Math.abs(y1-y2)));
				li.get(i).v = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			li = new LinkedList<Dot>();
			for(int i=0;i<n+2;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				li.add(new Dot(x,y));
			}
			min = 987654321;
			solve(0,0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	public static class Dot{
		int x;
		int y;
		boolean v;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
