package Asamsung;

import java.util.LinkedList;
import java.util.Scanner;

public class E2115 {
	static int map[][];
	static boolean v[][];
	static int N,M,C,ans,res;
	static void getPrice(int x,int y,int cnt,int sum,int price) {
		if(sum > C) return;
		res = Math.max(res, price);
		if(cnt == M) return;
		getPrice(x, y + 1, cnt + 1, sum + map[x][y], price + map[x][y] * map[x][y]);
	    getPrice(x, y + 1, cnt + 1, sum, price);
		
	}
	static void solve(int x,int y) {
		for(int i=y;i<y+M;i++) {
			v[x][i] = true;
		}
		res = 0;
		getPrice(x,y,0,0,0);
		int PriceA = res;
		int PriceB = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-M+1;j++) {
				if(!v[i][j]) {
					res = 0;
					getPrice(i,j,0,0,0);
					PriceB = Math.max(res, PriceB);
				}
			}
		}
		ans = Math.max(ans, PriceA+PriceB);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			v = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					solve(i,j);
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
