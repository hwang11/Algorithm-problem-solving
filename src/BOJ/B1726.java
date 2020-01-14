package Algo11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1726 {
	static int m,n;
	static int map[][];
	static boolean v[][][];
	static int ey,ex,ed,x,y,ans;
	static int ty,tx,td;
	static int idx[] = {1,3,2,0}; //동서남북 
	static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};//상우하좌 
	static int rota(int r,int d) {
		int nd = 0;
		if(r==0) nd = (d+1)%4;
		else nd = (d+3)%4;
		return nd;
	}
	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(ty,tx,0,td));
		v[ty][tx][td] = true;
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			if(dot.y == ey && dot.x == ex && dot.d == ed) { 
				ans = Math.min(ans,dot.c);
				return;
			}
			for(int i=1;i<4;i++) { //방향 그대로 앞으로 전진 
				int ny = dot.y + dir[dot.d][0]*i;
				int nx = dot.x + dir[dot.d][1]*i;
				if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
				if(v[ny][nx][dot.d]) continue;
				if(map[ny][nx] == 1) break;
				v[ny][nx][dot.d] = true;
				q.add(new Dot(ny,nx,dot.c+1,dot.d));
			}
			for(int i=0;i<2;i++) { //방향 바꾸기 
				int nd = rota(i,dot.d);
				if(v[dot.y][dot.x][nd]) continue;
				v[dot.y][dot.x][nd] = true;
				q.add(new Dot(dot.y,dot.x,dot.c+1,nd));
			}

		}

		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();//세로 
		n = sc.nextInt();
		map = new int[100][100];
		v = new boolean[100][100][4];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		ty = sc.nextInt()-1;
		tx = sc.nextInt()-1;
		td = sc.nextInt();
		td = idx[td-1];
		ey = sc.nextInt()-1;
		ex = sc.nextInt()-1;
		ed = sc.nextInt();
		ed = idx[ed-1];
		bfs();
		System.out.println(ans);
		
		
	}
	static class Dot{
		int x;
		int y;
		int c;
		int d;
		public Dot(int y,int x,int c,int d) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.d = d;
		}
	}
}
