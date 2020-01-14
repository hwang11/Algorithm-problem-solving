package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class E2117 {
	static int N,M,ans;
	static int map[][];
	static LinkedList<Dot> li;
	
	static int cost(int cnt,int k) {
		return (int) (cnt*M - (Math.pow(k, 2) + Math.pow(k-1, 2)));
	}
	static int dis(int y,int x,Dot h) {
		int d = Math.abs(y - h.y) + Math.abs(x - h.x);
		return d;
	}
	static void draw(int y,int x) {
		int k = 1;
		while(k<N*2) {
			int cnt = 0;
			for(int i=0;i<li.size();i++) {
				if(k > dis(y,x,li.get(i))) cnt++;
			}
			if(cost(cnt,k)>=0) ans = Math.max(ans,cnt);
			k++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			li = new LinkedList<Dot>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) li.add(new Dot(i,j));
				}
			}
			ans = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					draw(i,j);
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static class Dot{
		int y;
		int x;
		public Dot(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
