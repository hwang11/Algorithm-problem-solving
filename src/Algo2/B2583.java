package Algo2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2583 {
	static int m,n,k,ans;
	static int a[][];
	static int num[];
	static boolean v[][];
	static int dis[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static int bfs(int y,int x) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(y,x));
		a[y][x] = 1;
		int area = 1;
		while(!q.isEmpty()) {
			Dot d = q.poll();
			for(int i=0;i<4;i++) {
				int my = d.y + dis[i][0];
				int mx = d.x + dis[i][1];
				if(my >= m || my < 0 || mx >= n || mx < 0)continue;
				if(a[my][mx]==1)continue;
				a[my][mx] = 1;
				q.add(new Dot(my,mx));
				area++;
			}
		}
		return area;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[m][n];
		num = new int[101];
		v = new boolean[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = false;
			}
		}
		
		for(int i=0;i<k;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=y1;j<y2;j++) {
				for(int o=x1;o<x2;o++) {
					a[j][o] = 1;
				}
			}
		}
		ans = 0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j] == 0) {
					num[ans]=bfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		Arrays.sort(num);
		for(int i=num.length-ans;i<num.length;i++) {
			System.out.print(num[i]+" ");
		}
		
	}
	
	public static class Dot{
		int y;
		int x;
		public Dot(int y,int x) {
			this.x = x;
			this.y = y;
		}
	}
}
