package el;

import java.util.Arrays;
import java.util.LinkedList;

public class q2 {
	static LinkedList<Integer> li;
	static boolean visit[];
	static int max;
	static void dfs(int dep,int len,int v[]) {
		if(dep == len) {
			int sum = 0;
//			for(int i=0;i<li.size();i++) {
//				System.out.print(li.get(i)+" ");
//			}
			//System.out.println();
			for(int i=0;i<li.size()-1;i++) {
				sum += Math.abs(li.get(i)-li.get(i+1));
			}
			//System.out.println("sum"+sum);
			max = Math.max(sum, max);
		}
		for(int i=0;i<len;i++) {
			if(visit[i]) continue;
			visit[i] = true;
			li.add(v[i]);
			dfs(dep+1,len,v);
			visit[i] = false;
			li.removeLast();
		}
	}
	public static int solution(int[] v) {
		int answer = 0;
//		Arrays.sort(v);
//		for(int i=0;i<v.length/2 +1;i++) {
//			answer += Math.abs(v[i]-v[v.length-i-1]);
//			System.out.printf("%d %d %d\n",v[i],v[v.length-i-1],answer);
//		}
//		System.out.println(answer);
		li = new LinkedList<Integer>();
		visit = new boolean[v.length];
		dfs(0,v.length,v);
		answer = max;
		//System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		int a[] = {20,8,10,1,4,15};
		solution(a);
	}
}
