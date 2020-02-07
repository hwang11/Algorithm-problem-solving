package Graph;
import java.util.*;
//인접리스트로 구현.
public class BOJ1260 {
	public static void dfs(ArrayList<Integer>[] a, boolean[] visited, int v) {

		
		visited[v] = true;
		System.out.print(v + " ");

		for (int vv : a[v]) {

			if (!visited[vv]) {
				dfs(a, visited, vv);
			}

		}

	}
	
	public static void bfs(ArrayList<Integer>[] a,boolean[] visited,int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			//q.remove(cur);
			for (int vv : a[v]) {

				if (!visited[vv]) {
					q.add(vv);
					visited[vv] = true;
				}

			}
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N + 1];
		boolean visited[] = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) { 
			a[i] = new ArrayList<>(); //원소를 어레이리스트로.
		}
		
		for(int i=0;i<M;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1].add(v2);
			a[v2].add(v1);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(a[i]);
			System.out.println(a[i]);
		}
		dfs(a,visited,V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(a,visited,V);
	}
}