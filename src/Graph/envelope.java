package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class envelope {
	static int flag;
	static boolean v[],v1[];
	static Queue<Integer> q;
	static void bfs(int idx, int[][] arr) {
		q.add(idx);
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.println("n: "+n);
			for(int i=0;i<arr.length;i++) {
				if(v[i]) continue;
				if(arr[i][0] > arr[n][0] && arr[i][1] > arr[n][1]) {
					if(flag == 2) continue;
					flag = 1;
					q.add(i);
					v[i] = true;
					System.out.println("첫번째 "); 
				}
				if(arr[i][0] < arr[n][0] && arr[i][1] < arr[n][1]) {
					if(flag == 1) continue;
					flag = 2;
					q.add(i);
					v[i] = true;
					System.out.println("두번째 ");
				}
			}
		}
	}
	static int solution(int[][] arr) {
		flag = 0;
		int answer = 0;
		v = new boolean[arr.length];
		q = new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(v[i]) continue;
			System.out.println("--------------");
			bfs(i,arr);
			answer++;
		}
		System.out.println(answer);
		return answer;
	}
	public static void main(String args[]) {
		//int arr[][] = {{3, 5}, {7, 5}, {3, 3}, {2, 1}}; //조합 
		//int arr[][] = {{3, 4}, {1, 3}, {2, 5}, {1, 2}, {3, 5}, {2, 3}};
		int arr[][] = {{2, 3}, {4, 5}, {3, 4}};
		solution(arr);
	}
}
