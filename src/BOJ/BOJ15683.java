package BOJ;

import java.util.Scanner;

public class BOJ15683 {
	static int N,M;
	static int map[][];
	public static void dfs() {
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
}
