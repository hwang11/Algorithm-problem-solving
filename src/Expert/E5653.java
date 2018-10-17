package Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E5653 {
	static int n,m,k,ans;
	static Cell map[][];
	static int d[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	static Queue<Dot> q = new LinkedList<Dot>();
	
	public static void bfs(int cnt) { //상하좌우로 번식.
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int mx = dot.x + d[i][0];
				int my = dot.y + d[i][1];
				if(map[mx][my].x < 0) continue;

				if(map[mx][my].x > 0) {
					if((map[mx][my].l ==  map[dot.x][dot.y].l)) {
						if(map[mx][my].x < map[dot.x][dot.y].x) {
							Cell c = new Cell(cnt+1,map[dot.x][dot.y].x,(cnt+1)+map[dot.x][dot.y].x);
							map[mx][my] = c;
						}
						else {
							continue;
						}
					}
					else {
						continue;
					}
				}
				
				else {
					Cell c = new Cell(cnt+1,map[dot.x][dot.y].x,(cnt+1)+map[dot.x][dot.y].x);
					map[mx][my] = c;
				}
			}
		}
	
		
	}
	public static void dfs(int cnt) {
		if(cnt > 10) {
			return;
		}
		for(int i=0;i<30;i++) {
			for(int j=0;j<30;j++) {
				if(map[i][j].x <= 0) continue;
				if((map[i][j].x + map[i][j].l) == cnt) map[i][j].x = -1; //죽음.
				if((map[i][j].l) == cnt) {
					q.add(new Dot(i,j));
				}
			}
		}
		
		bfs(cnt);
		dfs(cnt+1);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			ans = 0;
			
			map = new Cell[30][30];
			for(int i=0;i<30;i++) {
				for(int j=0;j<30;j++) {
					map[i][j] = new Cell(0,0,0);
				}
			}
			for(int i=13;i<(n+13);i++) {
				for(int j=13;j<(m+13);j++) {
					int x = sc.nextInt();
					Cell c = new Cell(0,x,(0+x));
					map[i][j] = c;
				}
			}
			dfs(0);
			int count = 0;
			for(int i=0;i<30;i++) {
				for(int j=0;j<30;j++) {
					if(map[i][j].x > 0) {
						count++;
					}
					
				}
			}
			ans = count;
			System.out.println("#"+t+" "+ans);
		}
	}
	static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Cell{
		int b;
		int x;
		int l;
		public Cell(int b,int x,int l) {
			this.b = b;
			this.x = x;
			this.l = l;
		}
	}
}
