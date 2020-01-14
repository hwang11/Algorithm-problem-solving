package Algo4;

import java.util.Scanner;

public class E2115 {
	static int n,m,c,res;
	static int a[][];
	static boolean v[][];
	public static void getPrice(int x,int y,int cnt,int sum,int price) {
		if(sum>c) return;
		res = Math.max(res,price);
		if(cnt == m) return;
		
		getPrice(x,y+1,cnt+1,sum+a[x][y],price+a[x][y]*a[x][y]);
		getPrice(x,y+1,cnt+1,sum,price);
		
	}
	public static int solve(int x,int y) {
		for(int i=0;i<m;i++) {
			v[x][y+i] = true;
		}
		res = 0;
		getPrice(x,y,0,0,0);
		int priceA = res;
		
		int priceB = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-m+1;j++) {
				if(!v[i][j]) {
					res = 0;
					getPrice(i,j,0,0,0);
					priceB = Math.max(priceB,res);
				}
			}
		}
		return priceA + priceB;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			a = new int[n][n];
			v = new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-m+1;j++) {
					ans = Math.max(ans,solve(i,j));
				}
			}
			System.out.printf("#%d %d\n",t,ans);
			
			
		}
		
	}
	
}
