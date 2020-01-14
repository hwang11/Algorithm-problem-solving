package Expert;
//수영장. 조합문제.
import java.util.Scanner;

public class RE1952 {
	static int month[];
	static int c[];
	static int ans;
	public static void dfs(int now,int s) {
		if(now >= 13) {
			ans = Math.min(ans, s);
			return;
		}
		dfs(now+1,s+month[now]*c[1]);
		dfs(now+1,s+c[2]);
		dfs(now+3,s+c[3]);
		dfs(now+12,s+c[4]);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			
			month = new int[13];
			c = new int[5];
			
			
			for(int i=1;i<=4;i++) {
				c[i] = sc.nextInt();
			}
			for(int i=1;i<=12;i++) {
				month[i] = sc.nextInt();
			}
			ans = c[4];
			dfs(1,0);
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
