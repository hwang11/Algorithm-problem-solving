package BOJ;

import java.util.Scanner;

public class BB9663 {
	static int n, ans,a[];
	static boolean chk(int c) {
		for(int i=1;i<c;i++) {
			if(a[i]==a[c]) return false; //같은 행에 있으면 false 
			if(Math.abs(i-c) == Math.abs(a[i]-a[c])) return false; //대각선 
		}
		return true;
	}
	static void dfs(int dep) {
		System.out.printf("dfs(%d)\n",dep);
		if(dep == n) {
			ans++;
			return;
		}
		for(int i=1;i<=n;i++) {
			a[dep+1] = i; //i 행 dep 열 
			if(chk(dep+1)) {
				dfs(dep+1);
			}
			else {
				a[dep+1] = 0;
			}
		}
		a[dep] = 0; //방문 취소 
		System.out.println("취소 "+dep);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[15]; 
		ans = 0;
		for(int i=1;i<=n;i++) {
			a[1] = i;
			System.out.println(i+"열 ===================");
			dfs(1);
		}
		System.out.println(ans);
	}
}
