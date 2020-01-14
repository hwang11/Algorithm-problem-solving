package Asamsung;

import java.util.Scanner;

public class B2112 {
	static int D,W,K,ans;
	static int map[][];
	static int copy[][];
	static boolean check;
	static boolean v[];
	static int ty[];
	static boolean chk() {
		int cnt = 0; int cnt2 = 0;
		for(int i=0;i<W;i++) { //가로 
			cnt2 = 0;
			boolean flag = false;
			for(int j=0;j<D-1;j++) {//세로 
				if(map[j][i] == map[j+1][i]) {
					cnt2++;
				}
				else cnt2 = 0;
				if(cnt2 >= K-1) {
					flag = true;
					cnt++;
					break;
				}
			}
		}
		if(cnt == W) {
			return true;
		}
		
		return false;
	}
	static void copy() {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	static void back() {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	static void fill(int cnt,int goal) {
		if(cnt == goal) {
			copy();
			int m = 0;
			for(int i=0;i<D;i++) {
				if(!v[i]) continue;
				for(int j=0;j<W;j++) {
					if(v[i]) map[i][j]=ty[m]; 
				}
				if(v[i]) m++;
			}
			if(chk()) {
				check = true;
				ans = Math.min(ans, cnt);
			}
			back();
			return;
		}
		for(int i=0;i<2;i++) {
			ty[cnt] = i;
			fill(cnt+1,goal);
			ty[cnt] = 0;
		}
	}
	static void dfs(int cnt,int goal,int d) {
		if(cnt == goal) {
			fill(0,goal);
			return;
		}
		for(int i=d+1;i<D;i++) {
			v[i] = true;
			dfs(cnt+1,goal,i);
			v[i] = false;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			map = new int[D][W];
			v = new boolean[D];
			copy = new int[D][W];
			ty = new int[D];
			for(int i=0;i<D;i++) {
				for(int j=0;j<W;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			check = false;
			ans = Integer.MAX_VALUE;
			if(chk()) ans = 0;
			else {
				for(int i=2;i<=D;i++) {
					dfs(0,i,0);
					if(check) break;
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
