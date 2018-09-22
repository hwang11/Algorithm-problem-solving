package permu;
//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램

import java.util.Scanner;
public class BOJ15649 {
	static int n,m;
	static boolean v[];
	static int a[];
	public static void dfs(int d) {
		if(d == m) { //자리 수가 채워지면.
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+1+" ");
			}
			System.out.println();
		}
		for(int i = 0;i<n;i++) {
			if(!v[i]) {
				v[i] = true;
				a[d] = i;
				dfs(d+1);
				v[i] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = new boolean[10];
		a = new int[10];
		dfs(0);
		
	}
}
