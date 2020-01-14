package Expert;

import java.util.Scanner;
// 백트래킹, 4방향.. 이라서for문으로 해봤지만 재귀2개로 해봐야겠다...
//유의 할 점은 pre를 사용해야 변경된 값을 저장해서 비교할 수 있다는 것.
public class RE1949 {
	static int n,k,ans;
	static int map[][];
	static boolean v[][];
	static int d[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void move(int x,int y,int cnt,int pre,boolean flag) {	
		v[x][y] = true;
		if(ans < cnt) ans = cnt;
		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			if(mx < 0 || my < 0 || mx >= n || my >= n) continue;
			if(v[mx][my]) continue;
			if(flag) {
				if(map[mx][my] < map[x][y]) {
					move(mx,my,cnt+1,map[x][y],true);
				}
				else {
					if((map[mx][my]-k) < map[x][y]) {
						flag = true;
						move(mx,my,cnt+1,map[x][y]-1,false);
					}
				}
			}
			else {
				if(map[mx][my] < pre) {
					move(mx,my,cnt+1,map[mx][my],false);
				}
			}
		}
		v[x][y] = false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			v = new boolean[n][n];
			ans = 0;
			int max = 0;
			
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = false;
					max = Math.max(max, map[i][j]);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(max == map[i][j]) move(i,j,1,map[i][j],true);
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
