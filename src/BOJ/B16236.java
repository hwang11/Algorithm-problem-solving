package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16236 {
	static int n,x,y;
	static int eat;
	static int size;
	
	static int a[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean v[][];
	
	public static void bfs() {
		eat = 0;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y,0));
		v[x][y] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int eatX = 99;
			int eatY = 99;
			int cnt = 0;
			int qsize = q.size(); //변하면 안되서.
			for(int i=0;i<qsize;i++) {
				Dot dot = q.poll();
				for(int j=0;j<4;j++) {
					int mx = dot.x + dis[j][0];
					int my = dot.y + dis[j][1];
					
					if(mx >= n || mx < 0 || my >= n || my < 0) continue;
					if(v[mx][my]) continue;
					if(a[mx][my] > size) continue; 
					
					v[mx][my] = true;
					q.add(new Dot(mx,my,dot.cnt+1)); 
					
					if(a[mx][my]!=0 && a[mx][my]<size) {
						if(mx<eatX) {
							eatX = mx;
							eatY = my;
							cnt = dot.cnt+1;
						}
						else if(mx==eatX) {
							if(my<eatY) {
								eatX = mx;
								eatY = my;
								cnt = dot.cnt+1;
							}
						}
					}
				}
			}
			if(eatX != 99) {
				System.out.println("먹기."+eatX+","+eatY);
				//System.out.println("+cnt"+cnt);
				
				eat++;
				if(eat == size) {
					size++;
					eat = 0;
				}
				a[x][y] = 0;
				a[eatX][eatY] = 9;
				time += cnt;
				//System.out.println("더한 time "+time);
				x = eatX;
				y = eatY;
				init();
				q.clear();
				v[eatX][eatY] = true;
				q.add(new Dot(eatX,eatY,0));
			}
		}
		System.out.println(time);
	}
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		v = new boolean[n][n];
		init();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}
		size = 2;
		bfs();

	}
	public static class Dot{
		int x;
		int y;
		int cnt;
		public Dot(int x,int y,int c) {
			this.x = x;
			this.y = y;
			this.cnt = c;
		}
	}
}
