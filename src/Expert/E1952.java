package Expert;

import java.util.Scanner;

public class E1952 {
	static int c[];
	static int date[];
	static int total[];
	static int ans,cnt,min;
	public static void dfs(int now,int s) {
		if(now >= 13) {
			min = Math.min(min, s);
			//System.out.println("Return now: "+now+" s: "+s);
			//System.out.println();
			return;
		}
		//System.out.println("1일 dfs("+(now+1)+","+(s+date[now]*c[1])+")");
		dfs(now+1,s+date[now]*c[1]);
		//System.out.println("1달 dfs("+(now+1)+","+(s+c[2])+")");
		dfs(now+1,s+c[2]);
		//System.out.println("3달 dfs("+(now+1)+","+(s+c[3])+")");
		dfs(now+3,s+c[3]);
		//System.out.println("1년 dfs("+(now+1)+","+(s+c[4])+")");
		dfs(now+12,s+c[4]);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			c = new int[5];
			date = new int[13];
			
			for(int i=1;i<=4;i++) {
				c[i] = sc.nextInt();
			}
			min = c[4];
			for(int i=1;i<=12;i++) {
				date[i] = sc.nextInt();
			}
			dfs(1,0);
			System.out.println("#"+t+" "+min);
			
		}
	}
}
