package Expert;

import java.util.Scanner;

public class E4014 {
	static int x,n,ans;
	static int map[][];
	static void solve() {
		for(int i=0;i<n;i++) {
			int cur = map[i][0];
			int cnt = 0;
			for(int j=1;j<n;j++) {
				boolean flag = true;
				if(cur == map[i][j]) continue;
				else {
					if(1 == Math.abs(map[i][j] - cur)) {
						cnt++;
					}
					else {flag = false;}
					
				}
				if(cnt >= x && flag) {
					ans++;
				}
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			x = sc.nextInt();
			map = new int[n][n];
			solve();
			System.out.printf("#%d %d\n",t,ans);
		}
		
		
	}
}
