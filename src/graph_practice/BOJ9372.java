package graph_practice;
import java.util.*;
public class BOJ9372 {
	public static void bfs(int[] a,int v,boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			for (int i=0;i<m;i++) {
				if(a[v][i]==1 && !visited[i]) {
					
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int n = s.nextInt();
		int m = s.nextInt();
		boolean[] visited = new boolean[n];
		int a[][] = new int[n][n];
		for(int i=0;i<m;i++) {
				int v1 = s.nextInt();
				int v2 = s.nextInt();
				a[v1][v2] = 1;
				a[v2][v1] = 1;
		}
		
		
	}
}
