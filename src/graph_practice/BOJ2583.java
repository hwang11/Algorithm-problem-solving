package graph_practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2583 {
	static int m;
	static int n;
	static int k;
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static int map[][];
	static boolean c[][];
	static int num[];
	static Dot a[];
	static int cnt;
	static int ans;
	
	public static int bfs(Dot e) {
		cnt = 1;
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(e);
		while(!q.isEmpty()) {
			Dot dd = q.poll();
			map[dd.x][dd.y] = 1;
			for(int i=0;i<4;i++) {
				int mx = dd.x+d[i][0];
				int my = dd.y+d[i][1];
				if(mx<0 || mx>=n || my<0 || my>=m) continue;
				if(map[mx][my] == 1) continue; //ㅊ색칠한부분가지않게
				cnt ++;
				map[mx][my] = 1;
				q.add(new Dot(mx,my));
			}
		}
		return cnt;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[n+1][m+1];
		num = new int[n*m];
		a = new Dot[k];
		for(int i=0;i<k;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=x1;j<x2;j++) {
				for(int w=y1;w<y2;w++) {
					map[j][w] = 1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0) {
					num[ans]=bfs(new Dot(i,j));
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
		int x;
		int y;
		Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
