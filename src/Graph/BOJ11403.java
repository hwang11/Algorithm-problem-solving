package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11403 {
	static int n;
	static int map[][];
	static int ans[][];
	static boolean v[][];
	public static void bfs(int x,int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i=0;i<n;i++) {
				if(map[a][i] == 1 && v[a][i] == false) {
					if(i==y) {
						ans[x][y] = 1;
						return;
					}
					else {
						q.add(i);
						v[a][i] = true;
					}
				}
			}
		}
	}
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = false;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];//입력정보.
		ans = new int[n][n];//답.
		v = new boolean[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bfs(i,j);
				init();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
