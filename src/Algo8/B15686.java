package Algo8;

import java.util.LinkedList;
import java.util.Scanner;
//시간 초과 
public class B15686 {
	static int n,m,ans,sum,min1,min;
	static int map[][];
	static boolean v[];
	static LinkedList<Dot> c = new LinkedList<Dot>();
	static LinkedList<Dot> h = new LinkedList<Dot>();
	static LinkedList<Dot> li = new LinkedList<Dot>();
	public static void dfs(int cnt,int idx) {
		for(int i=idx;i<c.size();i++) {
			Dot d = c.get(i);
			if(v[i]) continue;
			v[i] = true;
			li.add(d);
			dfs(cnt+1,i);
			v[i] = false;
			li.removeLast();
		}
		if(cnt == m-1) { //m-1인건 main문에서 for문을 돌렸기 때문에..? 
			System.out.println("li "+li.size());
			sum = 0;
			for(int i=0;i<h.size();i++) {
				min1 = Integer.MAX_VALUE;
				for(int j=0;j<m;j++) {
					int value = Math.abs(h.get(i).x-li.get(j).x)+Math.abs(h.get(i).y-li.get(j).y);
					min1 = Math.min(min1, value);
				}
				sum += min1;
			}
			min = Math.min(min, sum);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		
		min = min1 = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) c.add(new Dot(i,j));
				if(map[i][j] == 1) h.add(new Dot(i,j));
			}
		}
		v = new boolean[c.size()];
		//시간 초과 
		for(int i=0;i<c.size();i++) {
			Dot dot = c.get(i);
			v[i]=true;
			li.add(dot);
			dfs(0,i);
			v[i]=false;
			li.removeLast();
		}
		System.out.println(min);
		
	}
	public static class Dot{
		int y;
		int x;
		public Dot(int y,int x) {
			this.x = x;
			this.y = y;
		}
	}
}
