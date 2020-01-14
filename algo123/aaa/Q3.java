package aaa;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q3{ //네이버 
	static boolean v[];
	static int max;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static int arr[][]; //인접행렬 
	static void bfs(int n,int[] cook,int or[][]) {
		PriorityQueue<Dot> pq = new PriorityQueue<Dot>();
		pq.add(new Dot(n,cook[n-1],0));
		while(!pq.isEmpty()) {
			Dot dot = pq.poll();
			boolean flag = false;
			for(int i=0;i<cook.length;i++) {
				//if(v[i]) continue;
				if(arr[i][dot.num] == 1) {
					System.out.println("출발"+dot.num+"도착 "+i+"시간 "+dot.time);
					v[i] = true;
					flag = true;
					pq.add(new Dot(i,dot.time+cook[i],dot.step+1));
				}
			}
			if(!flag) {
				max = Math.max(max, dot.time);
			}
		}

		//v[n] = false;
	}
	public static int[] solution(int[] cook_times,int [][] order,int k) {
		int[] answer = new int[2];
		int cnt = 0;
		bfs(k,cook_times,order);
		for(int i=0;i<cook_times.length;i++) {
			if(v[i]) cnt++;
		}
		answer[0] = cnt;
		answer[1] = max;
		System.out.println(cnt+","+max);
		return answer;
	}
	public static void main(String[] args) {
//		int[] acook = {5, 30, 15, 30, 35, 20, 4};
//		int[][] border = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};	
//		int k = 6;
		int[] acook = {5, 3, 2};
		int[][] border = {{1, 2}, {2, 3}, {1, 3}};	
		int k = 3;
		arr = new int[acook.length+1][acook.length+1];
		v = new boolean[acook.length+1];
		
		for(int i=0;i<border.length;i++) {
			int s = border[i][0];
			int e = border[i][1];
			arr[s][e] = 1;
		}
		solution(acook,border,k);
	}
	static class Dot implements Comparable<Dot>{
		int num,time,step;
		public Dot(int n,int t,int s) {
			this.num = n;
			this.time =t;
			this.step = s;
		}
		
		@Override
		public int compareTo(Dot target) {
	        return this.time <= target.time ? 1 : -1;
	    }
	}
}
