package practice28;

import java.util.Scanner;

public class E1949 {
	static int map[][];
	static boolean v[][];
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n,k,max;
	public static void dfs(int x,int y,int len,int pre,boolean flag) {
		v[x][y] = true;
		if(max < len) max = len;

		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			if(mx == 0 || mx == n + 1 || my == n+1 || my == 0 || v[mx][my]) continue;
			if(flag) {
				if(map[x][y] > map[mx][my]) dfs(mx,my,len+1,map[mx][my],true);
				else if(map[x][y] > map[mx][my] - k) dfs(mx,my,len+1,map[x][y]-1,false); //k사용하기.
			}
			else { //k 사용 후.
				if(pre > map[mx][my]) dfs(mx,my,len+1,map[mx][my],false);
			}
		}
		v[x][y] = false;
	}
	
	public static void init() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				v[i][j] = false;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			n = sc.nextInt();
			k = sc.nextInt();
			v = new boolean[9][9];
			map = new int[9][9];
			max = 0;
			int high = 0;
			for(int j=1;j<=n;j++) {
				for(int m=1;m<=n;m++) {
					map[j][m] = sc.nextInt();
					high = Math.max(map[j][m], high);
				}
			}
			for(int j=1;j<=n;j++) {
				for(int m=1;m<=n;m++) {
					init();
					if(map[j][m] == high) dfs(j,m,1,map[j][m],true);
				}
			}
			
			System.out.println("#"+i+" "+max);
		}
		
	}
}
