package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B2667 {
	static int N,cnt,total;
	static char map[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static void dfs(int x,int y) {
		v[x][y] = true;
		total++;
		for(int i=0;i<4;i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == '0') continue;
			if(v[nx][ny]) continue;
			dfs(nx,ny);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		v = new boolean[N][N];
		String a = sc.nextLine();
		for(int i=0;i<N;i++) {
			String s = sc.nextLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int arr[] = new int[N*N];
		LinkedList<Integer> li = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == '1' && !v[i][j]) {
					total = 0;
					dfs(i,j);
					arr[cnt++] = total;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > 0) System.out.println(arr[i]);
		}
	}
}
