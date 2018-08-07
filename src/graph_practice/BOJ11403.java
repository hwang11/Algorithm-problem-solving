package graph_practice;

import java.util.Scanner;

public class BOJ11403 {
	static int n;
	static int map[][];
	static int ans[][];
	
	public static void dfs(int x,int y) {
		for(int i=0;i<n;i++) {
			if(map[x][i] == 0) continue;
			dfs(i,y);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];//입력정보.
		ans = new int[n][n];//답.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dfs(i,j);
			}
		}
	}
}
