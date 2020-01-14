package Asamsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16234 {
	static int N,L,R,cnt2;
	static int map[][];
	static int num[][];
	static int v[][];
	static boolean flag,flag2;
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static void divide() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(v[i][j]!=0) {
					map[i][j] = num[v[i][j]][0]/num[v[i][j]][1];
				}
			}
		}
	}
	static boolean cal(int y,int x,int ny,int nx) {
		int d = Math.abs(map[y][x]-map[ny][nx]);
		if(d>=L && d<= R) return true;
		return false;
	}
	static void bfs(int y,int x) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(y,x));
		cnt2++;
		num[cnt2][0] = 0;
		num[cnt2][1] = 0;
		int tmp = v[y][x];
		v[y][x] = cnt2;
		num[cnt2][0] += map[y][x];
		num[cnt2][1]++; 
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int ny = dot.y + dr[i][0];
				int nx = dot.x + dr[i][1];
				if(ny <0 || nx < 0 || ny>= N || nx>= N) continue;
				if(v[ny][nx]!=0) continue;
				if(cal(dot.y,dot.x,ny,nx)) {
					q.add(new Dot(ny,nx));
					flag2 = true;
					v[ny][nx] = cnt2;
					num[cnt2][0] += map[ny][nx];
					num[cnt2][1]++; 
				}
			}
		}
		if(!flag2) v[y][x] = tmp;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		int cnt = 0;
		map = new int[N][N];
		num = new int[2501][2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while(true) {
			flag = false;
			cnt2 = 0;
			v = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					flag2 = false;
					bfs(i,j);
					if(flag2) {
						flag = true;
					} 
				}
			}
			if(flag) {
				divide();
				cnt++;
			}
			if(!flag) break;
		}
		System.out.println(cnt);

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
