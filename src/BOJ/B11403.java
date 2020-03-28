package BOJ;

import java.util.Scanner;

public class B11403 {
	static int n, a[][], map[][];
	static boolean v[];

	static void dfs(int s) {
		for (int i = 0; i < n; i++) { // 갈 수 있는 점까지 가기 
			if (a[s][i] == 1 && !v[i]) {
				v[i] = true;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		map = new int[n][n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			v = new boolean[n];
			dfs(i);
			for(int j=0;j<n;j++) {
				if(v[j]) map[i][j] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
