package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7562 {
	static boolean v[][];
	static int map[][];
	static int startx,starty,endx,endy;
	static int size,ans;
	static int dr[][] = {{1,2},{2,1},{-1,2},{-2,1},{-1,-2},{-2,-1},{1,-2},{2,-1}};
	static void bfs() {
		v[startx][starty] = true;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(startx,starty, 0));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			if(dot.x == endx && dot.y == endy) {
				System.out.println(dot.cnt);
				return;
			}
			for(int i=0;i<8;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || nx >= size || ny < 0 || ny >=size) continue;
				if(v[nx][ny]) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny,dot.cnt+1));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			size = sc.nextInt();
			map = new int[size][size];
			v = new boolean[size][size];
			startx = sc.nextInt();
			starty = sc.nextInt();
			endx = sc.nextInt();
			endy = sc.nextInt();
			bfs();
		}
	}
	static class Dot{
		int x,y,cnt;
		public Dot(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
