package graph_practice;
import java.util.*;
//bfs,dfs인접행렬로 구현.
public class BFS {
	static int n = 0;
	static int m = 0;
	static int a [][];
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
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v+" ");
			visited[v] = true;
			for(int i=1;i<=n;i++) {
				if(a[v][i]==1&&!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//정점개수..
		m = sc.nextInt();//간선개수..
		int v = sc.nextInt();//시작 정점.
		a = new int[n+1][n+1];
		visited = new boolean[n+1]; //정점방문여부체크.
		
		
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1][v2] = a[v2][v1] = 1;
		}
		
		dfs(v);
		Arrays.fill(visited,false);
		System.out.println();
		bfs(v);
	}
}
