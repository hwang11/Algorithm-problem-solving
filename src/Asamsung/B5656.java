package Asamsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5656 {
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,W,H,ans;
	static int B[];
	static int map[][],copy[][];
	static Queue<Dot> q;
	static void back() {
		for(int i=0;i<H;i++) 
			for(int j=0;j<W;j++) map[i][j] = copy[i][j];
	}
	static void down() {
		for(int i=0;i<W;i++) {
			for(int j=H-1;j>0;j--) {
				if(map[j][i] == 0) {
					for(int y=j-1;y>=0;y--) {
						if(map[y][i] != 0) {
							map[j][i] = map[y][i];
							map[y][i] = 0;
							break;
						}
					}
				}
			}
		}
		
	}
	static void boom(int x,int y) {
		int k = map[x][y];
		for(int i=0;i<4;i++) {
			for(int j=0;j<k;j++) {
				int nx = x + dr[i][0]*j;
				int ny = y + dr[i][1]*j;
				if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				if(map[nx][ny] > 0) {
					if(map[nx][ny] > 1) {
						q.add(new Dot(nx,ny));
					}
					else map[nx][ny] = 0;
				}
			}
		}
		map[x][y] = 0;
		if(!q.isEmpty()) {
			Dot dot = q.poll();
			boom(dot.x,dot.y);
		}
	}
	static void find(int n) {
		int st = 0;
		for(int j=0;j<H;j++) { //가장 위에 있는 점 찾기 
			if(map[j][n] >0) {
				st = j;
				break;
			}
		}
		q = new LinkedList<Dot>();
		boom(st,n);
		down();
	}
	static int cal() { //벽돌개수 세기 
		int cnt = 0;
		for(int i=0;i<H;i++) 
			for(int j=0;j<W;j++) 
				if(map[i][j] > 0) cnt++;
		return cnt;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			copy = new int[H][W]; 
			B = new int[4];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map[i][j] = copy[i][j] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;
			for(B[0]=0;B[0]<W;B[0]++) {
				for(B[1]=0;B[1]<W;B[1]++) {
					for(B[2]=0;B[2]<W;B[2]++) {
						for(B[3]=0;B[3]<W;B[3]++) {
							for(int i=0;i<N;i++) {
								find(B[i]);
							}
							ans = Math.min(ans, cal());
							back();
							if(N < 4)break;
						}
						if(N<3) break;
					}
					if(N<2) break;
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
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
