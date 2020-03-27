package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1389 {
	static int N,M,ans;
	static int arr[][];
	static boolean v[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		v = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		int min = Integer.MAX_VALUE;
		int tmp = 0;
		ans = 0;
		for(int i=1;i<=N;i++) {
			Queue<Integer> q = new LinkedList<Integer>(); 
			q.add(i);
			v[i][i] = true;
			tmp = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int j=1;j<=N;j++) {
					if(!v[i][j] && arr[now][j]==1) {
						arr[i][j] = arr[i][now] + arr[now][j]; //최단경로 
						q.add(j);
						v[i][j] = true;
						tmp += arr[i][j];
					}
				}
			}
			
			if(min > tmp) {
				min = tmp;
				ans = i;
			}
			
		}
		System.out.println(ans);
		
	}
}