package BOJ;

import java.util.LinkedList;
import java.util.Queue;

public class network {
    static boolean v[]; 
	static void bfs(int n,int s,int[][] a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()) {
			s = q.poll();
			for(int i=0;i<n;i++) {
				if(v[i]) continue;
				if(a[s][i] == 1 && a[i][s] == 1 && i!=s) {
					q.add(i);
					v[i] = true;
				}
			}
		}
		
	}
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        for(int i=0;i<n;i++) {
        	if(!v[i]) {
        		bfs(n,i,computers);
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String args[]) {
		int a[][] = {{1,1,0},{1,1,1},{0,1,1}};
		int ans = solution(3,a);
		System.out.println(ans);
	}
}
