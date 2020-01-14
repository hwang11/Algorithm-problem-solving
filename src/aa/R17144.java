package aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class R17144 {
	static int R,C,T;
	static ArrayList<Dot> li;
	static Queue<Dot> q;
	static int map[][];
	static int cp[][];
	static int cw[] = {3,0,2,1}; // 윗부분 
	static int cww[] = {3,1,2,0}; //아랫부분 
	static int dr[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //상,하 좌 우 
	public static void rotate(int cx,int cy, int a[]) {
		int x = cx;
		int y = cy+1;
		map[x][y] = 0;
		for(int i=0;i<4;i++) {
			while(true) {
				int mx = x + dr[a[i]][0];
				int my = y + dr[a[i]][1];
				if(mx < 0 || my < 0 || mx >= R || my >= C) break;
				if(mx == cx && my == cy) break;
				map[mx][my] = cp[x][y];
				x = mx;
				y = my;
			}
		}
		
	}
	public static  void spread() {
		q = new LinkedList<Dot>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] > 4) q.add(new Dot(i,j,map[i][j]));
			}
		}
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int t = d.dust/5;
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int mx = d.x + dr[i][0];
				int my = d.y + dr[i][1];
				if(mx < 0 || my < 0 || mx >= R || my >= C) continue;
				if(map[mx][my] == -1) continue;
				map[mx][my] += t;
				cnt++;
			}
			map[d.x][d.y] -= t*cnt;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		li = new ArrayList<Dot>();
		map = new int[R][C];
		cp = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) li.add(new Dot(i,j,0));
			}
		}
		for(int t=0;t<T;t++) {
			spread();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					cp[i][j] = map[i][j];
				}
			}
			rotate(li.get(0).x,li.get(0).y,cw);
			rotate(li.get(1).x,li.get(1).y,cww);
		}
		int ans = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] >0) ans+= map[i][j];
			}
		}
		System.out.println(ans);
	}
	static class Dot{
		int x;
		int y;
		int dust;
		public Dot(int x,int y,int d) {
			this.x = x;
			this.y = y;
			this.dust =d;
		}
	}
}

