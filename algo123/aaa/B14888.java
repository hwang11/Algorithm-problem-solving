package aaa;

import java.util.Scanner;

public class B14888 {
	static int N, min, max;
	static int c[], value[];

	static void dfs(int dep, int num) {
		if (dep == N) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			// return;
		}
		for (int i = 0; i < 4; i++) {
			if (c[i] == 0)
				continue;
			c[i]--;
			if (i == 0) {
				dfs(dep + 1, num + value[dep]);
			} else if (i == 1) {
				dfs(dep + 1, num - value[dep]);
			} else if (i == 2) {
				dfs(dep + 1, num * value[dep]);
			} else if (i == 3) {
				dfs(dep + 1, num / value[dep]);
			}
			c[i]++;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		c = new int[4];
		value = new int[N];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE; //max값 초기화가 제대로 안되어있어서 틀림 
		for (int i = 0; i < N; i++) {
			value[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			c[i] = sc.nextInt();
		}
		dfs(1, value[0]);
		System.out.println(max);
		System.out.println(min);
	}
}
