package aaa;

import java.util.LinkedList;
import java.util.Scanner;

// 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s) 시계방향으로 1칸씩 이동 
//순서상관없으므로모든경우의수를 봐야한다. 
public class B17406 {
	static int N, M, K, R, C, S, min;
	static int arr[][];
	static int copy[][];
	static int init[][];
	static Dot dotarr[];
	static boolean v[];
	static LinkedList<Integer> li = new LinkedList<Integer>();

	static void copy(int a[][], int b[][]) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	static void rotate(int idx) {
		Dot dot = dotarr[idx];
		int r = dot.r;
		int c = dot.c;
		int s = dot.s;
		int bigr = r + s;
		int smallr = r - s;
		int bigc = c + s;
		int smallc = c - s;
		while (true) {
			for (int i = smallc; i < bigc; i++) { // ex a[1][3] <- a[1][2] 증가
				arr[smallr][i + 1] = copy[smallr][i];
			}
			for (int i = bigc; i > smallc; i--) { // ex a[5][5] <- a[5][6] 감소
				arr[bigr][i - 1] = copy[bigr][i];
			}
			for (int i = bigr; i > smallr; i--) { // ex a[4][2] <- a[5][2] 감소
				arr[i - 1][smallc] = copy[i][smallc];
			}
			for (int i = smallr; i < bigr; i++) { // ex a[2][6] <- a[1][6] 증가
				arr[i + 1][bigc] = copy[i][bigc];
			}
			bigr--;
			bigc--;
			smallr++;
			smallc++;
			if (Math.abs(bigr - smallr) <= 1 || Math.abs(bigc - smallc) <= 1)
				break;
		}
	}
	static void arrmin() { // 최소값 구하기
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	static void dfs(int dep) { // 순서정하기
		if (dep == K) {
			// 초기화 필요
			copy(arr, init);
			for (int i = 0; i < K; i++) {
				copy(copy, arr);
				rotate(li.get(i));
			}
			arrmin();
		}
		for (int i = 0; i < K; i++) {
			if (v[i])
				continue;
			v[i] = true;
			li.add(i);
			dfs(dep + 1);
			v[i] = false;
			li.removeLast();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N + 1][M + 1];
		init = new int[N + 1][M + 1];
		v = new boolean[K];
		copy = new int[N + 1][M + 1];
		min = Integer.MAX_VALUE;
		dotarr = new Dot[K];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = init[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < K; i++) {
			R = sc.nextInt();
			C = sc.nextInt();
			S = sc.nextInt();
			dotarr[i] = new Dot(R, C, S);
		}
		dfs(0);
		System.out.println(min);
	}

	static class Dot {
		int r, c, s;
		public Dot(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
