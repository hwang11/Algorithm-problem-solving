package Asamsung;

import java.util.LinkedList;
import java.util.Scanner;

public class B9205 {
	static int n;
	static Dot arr[];
	static boolean v[];
	static LinkedList<Integer> adj[];
	static boolean chk(int x1,int y1,int x2,int y2) {
		int d = 0;
		d = Math.abs(x1-x2) + Math.abs(y1-y2);
		if(d <= 1000) return true;
		return false;
	}
	static void dfs(int d) {
		v[d] = true;
		for(int i=0;i<adj[d].size();i++) {
			int next = adj[d].get(i);
			if(v[next]) continue;
			dfs(next);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			n = sc.nextInt();
			arr = new Dot[n+2];
			v = new boolean[n+2];
			adj = new LinkedList[n+2];
			for(int i=0;i<n+2;i++) {
				adj[i] = new LinkedList<Integer>();
			}
			for(int i=0;i<n+2;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new Dot(x,y);
			}
			for(int i=0;i<n+2;i++) {
				for(int j=1;j<n+2;j++) {
					if(i==j) continue;
					if(chk(arr[i].x,arr[i].y,arr[j].x,arr[j].y)){
						adj[i].add(j);
						adj[j].add(i);
					}
				}
			}
			dfs(0);
			if(v[n+1])System.out.println("happy");
			else System.out.println("sad");
		}
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
