package Expert;

import java.util.LinkedList;
import java.util.Scanner;
//백트래킹 [미완]
public class E1248 {
	static int n,ox,oy,hx,hy,sum,min,x1,y1,x2,y2;
	static LinkedList<Dot> li;
	
	public static void dfs(int cnt) {
		if(cnt == li.size()-1) {
			min = Math.min(min, sum);
			return;
		}
		if(cnt >= li.size()-1) return;
		
		for(int i=0;i<li.size();i++) {
			int x1 = li.get(i).x;
			int y1 = li.get(i).y;
			int x2 = li.get(i+1).x;
			int y2 = li.get(i+1).y;
			if(cnt == 0) {
				sum += (Math.abs(x1-ox) + Math.abs(y1-oy));
				dfs(cnt+1);
				sum -= (Math.abs(x1-ox) + Math.abs(y1-oy));
			}
			else {
				sum += (Math.abs(x1-x2) + Math.abs(y1-y2));
				dfs(cnt+1);
				sum -= (Math.abs(x1-x2) + Math.abs(y1-y2));
			}
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			ox = sc.nextInt();
			oy = sc.nextInt();
			li = new LinkedList<Dot>();
			li.add(new Dot(ox,oy));
			hx = sc.nextInt();
			hy = sc.nextInt();
			
			for(int i=0;i<n;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				li.add(new Dot(x,y));
			}
			li.add(new Dot(hx,hy));
			min = Integer.MAX_VALUE;
			dfs(0);
			System.out.println(min);
		}
	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
