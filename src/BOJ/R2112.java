package Asamsung;

import java.util.Scanner;

public class R2112 {
	static int D,W,K,ans;
	static int map[][];
	static boolean flag;
	static boolean chk() {
		int cnt = 0; int cnt2 = 0;
		for(int i=0;i<W;i++) { //가로 
			cnt2 = 0;
			for(int j=0;j<D-1;j++) {//세로 
				if(map[j][i] == map[j+1][i]) {
					cnt2++;
				}
				else cnt2 = 0;
				if(cnt2 >= K-1) {
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
	
	static void dfs(int cnt,int goal,int d) {
		if(cnt == goal) {
			if(chk()) {
				flag = true;
			}
			return;
		}
		int tmp[][] = new int[1][21];
		for(int i=d;i<D;i++) {
			for(int j=0;j<=1;j++) {//a,b두개중에 고르기 
				for(int k=0;k<W;k++) { //약품 뿌리기 
					tmp[0][k] = map[i][k];
					map[i][k] = j;
				}
				dfs(cnt+1,goal,i+1);
				for(int k=0;k<W;k++){
					map[i][k] = tmp[0][k]; //백트래킹 
				}
			}
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
			for(int i=0;i<D;i++) {
				for(int j=0;j<W;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			flag = false;
			for(int i=0;i<=D;i++) {
				dfs(0,i,0);
				if(flag) {
					ans = i;
					break;
				}
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
