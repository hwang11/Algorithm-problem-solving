package Expert;

import java.util.Arrays;
import java.util.Scanner;
//백트래킹, 사각형 그리는 방향, return 조건 유의.
public class RE2105 {
	static int n,ans,start_x,start_y;
	static int map[][];
	static boolean v[][];
	static boolean num[];
	static int dis[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};//사각형 그리는 순서 우하,좌하,좌상,우상.
	
	public static void move(int x,int y,int cnt,int d) {
		if(d == 4) return;
		int mx = x + dis[d][0];
		int my = y + dis[d][1];
		
		if(mx <= 0 || my <= 0 || mx > n || my > n) return;
		
		if(v[mx][my] || num[map[mx][my]]) {
			if(start_x == mx && start_y == my) {
				
				if(cnt>ans) {
					ans = cnt;
				}
				return;
			}
			else {
				return; // 숫자가 중복인 경우.
			}
		}
		v[mx][my] = true;
		num[map[mx][my]] = true;
		move(mx,my,cnt+1,d);
		move(mx,my,cnt+1,d+1);
		v[mx][my] = false;
		num[map[mx][my]] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			
			map = new int[n+1][n+1];
			v = new boolean[n+1][n+1];
			num = new boolean[101];
			ans = 0;
			Arrays.fill(num, false);
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = false;
				}
			}
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					start_x = i;
					start_y = j;
					v[i][j] = true;
					num[map[i][j]] = true;
					move(i,j,1,0);
					v[i][j] = false;
					num[map[i][j]] = false;
				}
			}
			
			if(ans < 4) ans = -1;
			System.out.println("#"+t+" "+ans);
		}
	}
}
