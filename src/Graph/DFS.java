package Graph;
import java.util.*;
public class DFS {
	static int n,m;
	static int a[][];
	static boolean visited[];
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int i=1;i<=n;i++) {
			if(a[v][i]==1&&!visited[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n+1][m+1];
		visited = new boolean[n+1];
		int v = sc.nextInt();
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = a[v2][v1] = 1;
		}
		dfs(v);
		
	}
}
