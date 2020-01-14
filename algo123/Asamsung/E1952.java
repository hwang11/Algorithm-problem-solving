package Asamsung;

import java.util.Scanner;

public class E1952 {
	static int m[];
	static int c[];
	static boolean v[];
	static int ans;
	static void dfs(int now,int money) {
		if(now >= 13) { //어쨌든 ㄱ끝까지 봐야되니까 
			ans = Math.min(money,ans);
			return;
		}
	    if(c[now] == 0){
	    	
	        dfs(now+1,money);
	        return ;
	    }
		dfs(now+1,money+(m[0]*c[now])); //1일 
		dfs(now+1,money+m[1]); //1달 		
		dfs(now+3,money+m[2]); //3달.
		dfs(now+12,money+m[3]); //1년. 
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			m = new int[4];
			c = new int[13];
			ans = Integer.MAX_VALUE;
			v = new boolean[13];
			for(int i=0;i<4;i++) m[i] = sc.nextInt();
			for(int i=1;i<=12;i++) c[i] = sc.nextInt();
			dfs(1,0);
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
}
