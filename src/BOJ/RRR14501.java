package Algo10;

import java.util.Scanner;
//브루트포스 for문 이용 
public class RRR14501 {
	static int n,ans;
	static int t[];
	static int p[];
	public static void dfs(int idx,int sum) {
		System.out.printf("dfs(%d,%d) 들어옴.\n",idx,sum);
		if(idx >= n +1) {
			ans = Math.max(ans, sum);
			System.out.println("완성 sum:"+sum);
			return;
		}
		for(int i = idx + t[idx];i<=n+1;i++) {
			//System.out.println("i:"+i+", idx:"+idx);
			dfs(i,sum + p[idx]);
		}
		System.out.println("다돌았다 ");
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n+1];
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		ans = 0;
		dfs(1,0);
		for(int i=1;i<=n;i++) { //1번째날에서 시작하는 거 뿐만아니라 모든 날 기준으로 시작하는 걸 봐야하므로.
			System.out.println("시작 ");
			dfs(i,0);
		}
		System.out.println(ans);
	}
}
