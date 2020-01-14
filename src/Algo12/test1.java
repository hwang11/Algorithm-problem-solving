package Algo12;

import java.util.Scanner;

public class test1 {
	static int N,M,ans,cnt;
	static int map[][];
	static int scu[][];
	static int dr[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int di[][] = {{-1,-1},{1,1},{-1,1},{1,-1}};
	
	static boolean chk(int y,int x) {
		if(y < 0 || x < 0 || y>= N || x >= N) return false;
		return true;
	}
	static void init() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				scu[i][j] = 0;
			}
		}
	}
	static int cost(int k) {
		int sum = 0;
		cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(scu[i][j] == 1 && map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return (int) (cnt*M - (Math.pow(k, 2) + Math.pow(k-1, 2)));
	}
	static void print() {
		System.out.println();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(scu[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void draw(int y,int x,int k) {
		scu[y][x] = 1;
		boolean flag = false;
		for(int i=0;i<k;i++) { //상하좌우 
			for(int j=0;j<4;j++) {
				int ny = y + dr[j][0]*i;
				int nx = x + dr[j][1]*i;
				if(chk(ny,nx)) {
					System.out.printf("%d,%d\n",ny,nx);
					scu[ny][nx] = 1;
					flag = true;
				}
				else continue;
			}
		}
		for(int i=0;i<k-1;i++) { //대각선 
			for(int j=0;j<4;j++) {
				int ny = y + di[j][0];
				int nx = x + di[j][1];
				if(chk(ny,nx)) {
					System.out.printf("%d,%d\n",ny,nx);
					scu[ny][nx] = 1;
					flag = true;
				}
				else continue;
			}
		}
		print();

			
		
				
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			scu = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					for(int o=0;o<5;o++) {
//						draw(i,j,o);
//						init();
//					}
//				}
//			}
			draw(3,3,3);

			
			System.out.println(ans);
		}
	}
}
