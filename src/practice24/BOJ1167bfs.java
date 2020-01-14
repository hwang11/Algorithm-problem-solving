package practice24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1167bfs {
	static int v;
	static int arr[][] = new int[v][v];
	static boolean visited[];
	static int sum[];
	static int sMax = 0;
			
	public static void bfs(int pos) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(pos);
		visited[pos] = true;
		sum[pos] = 0; 
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1;i<=v;i++) {
				if(arr[x][i] == arr[i][x] && 0!=arr[i][x] && visited[i] == false) {
					q.add(i);
					visited[i] = true;
					sum[i] = sum[x] + arr[x][i];
					if(sMax<sum[i]) {
						sMax = sum[i];
					}
				}
			}
		}

	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		arr = new int[v+1][v+1];
		visited = new boolean[v+1];
		sum = new int[v+1];
		for(int i=0;i<v;i++) {
			int s = sc.nextInt();
			while(true) {
				int a = sc.nextInt();
				if(a == -1) break;
				else {
					int e =	a;
					int d = sc.nextInt();
					arr[s][e] = d;
					arr[e][s] = d;
				}
			}
		}
		bfs(1);
		System.out.println(sMax);
	}
}
