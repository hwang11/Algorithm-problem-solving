package Asamsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E1953 {
	static int N,M,R,C,L,ans,time;
	static int map[][];
	static int copy[][];
	static boolean v[][];
	static int d[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우 
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int[] con(int s) {
		int[] a = {0,0,0,0};
		switch(s) {
		case 1: int[] chk = {1,1,1,1};
				return chk;
		case 2: int[] chk2 = {1,1,0,0};
				return chk2;
		case 3: int[] chk3 = {0,0,1,1};
		return chk3;
		case 4: int[] chk4 = {1,0,0,1};
		return chk4;
		case 5: int[] chk5 = {0,1,0,1};
		return chk5;
		case 6: int[] chk6 = {0,1,1,0};
		return chk6;
		case 7: int[] chk7 = {1,0,1,0};
		return chk7;
		}
		return a;
	}
	static void go() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(R,C,0));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			if(dot.cnt == L-1) {
				break;
			}
			int chk[] = con(map[dot.y][dot.x]);
			for(int i=0;i<4;i++) {
				if(chk[i] == 1) {
					int ny = dot.y + d[i][0];
					int nx = dot.x + d[i][1];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
					if(v[ny][nx]) continue;
					if(map[ny][nx]==0) continue;
					int val = map[ny][nx];
					if(i==0) { //상 
						if(val == 1 || val == 2 || val == 5 || val == 6) {
							v[ny][nx] = true;
							q.add(new Dot(ny,nx,dot.cnt+1));
							copy[ny][nx] = dot.cnt+1;
							ans++;

							
						}
					}
					if(i==1) { //하 
						if(val == 1 || val == 2 || val == 4 || val == 7) {
							v[ny][nx] = true;
							q.add(new Dot(ny,nx,dot.cnt+1));
							copy[ny][nx] = dot.cnt+1;
							ans++;

						}
					}
					if(i==2) { //좌 
						if(val == 1 || val == 3 || val == 4 || val == 5) {
							v[ny][nx] = true;
							q.add(new Dot(ny,nx,dot.cnt+1));
							copy[ny][nx] = dot.cnt+1;
							ans++;

						}
					}
					if(i==3) { //우  
						if(val == 1 || val == 3 || val == 6 || val == 7) {
							v[ny][nx] = true;
							q.add(new Dot(ny,nx,dot.cnt+1));
							copy[ny][nx] = dot.cnt+1;
							ans++;

						}
					}
				}
			}			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			ans = 1;
			map = new int[N][M];
			copy = new int[N][M];
			v = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			v[R][C] = true;
			go();
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static class Dot{
		int y;
		int x;
		int cnt;
		public Dot(int y,int x,int cnt) {
			this.y =y;
			this.x =x;
			this.cnt = cnt;
		}
	}
}
