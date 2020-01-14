package aa;

import java.util.LinkedList;
import java.util.Queue;

public class a2 {
	static int arr[][];
	static boolean v[];
	//필요한 최소 다리갯수 = 영역개수 -1 
	static void bfs(int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(d);
		int st = 0;
		while(!q.isEmpty()) {
			st = q.poll();
			for(int i=1;i<v.length;i++) {
				if(v[i]) continue;
				if(arr[st][i]!=1) continue;
				v[i] = true;
				q.add(i);
			}
		}
	}
	public static int solution(int V, int[][] bridge) {
		int answer = -1;
		arr = new int[V+1][V+1];
		v = new boolean[V+1];
		for (int i = 0; i < bridge.length; i++) {
			int v1 = bridge[i][0];
			int v2 = bridge[i][1];
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		for(int i=1;i<=V;i++) { //정점만큼 반복하여 영역개수세야함 
			if(v[i]) continue;
			bfs(i);
			answer++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 5 
		int a[][] = {{1, 2}, {2, 3}, {4, 5}};
		solution(5, a);
		
		int b[][] = {{1, 2}, {2, 3}, {4, 5}};
		solution(6,b);
	}

}
