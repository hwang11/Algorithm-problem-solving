package aaa;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Dot> pq = new PriorityQueue<Dot>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String st = sc.next();
			if(st.equals("enqueue")) {
				int v = sc.nextInt();
				if(pq.contains(v)) {
					pq.
				}
				
			}else {
				System.out.println(pq.poll());
			}
		}

	}
	class Dot implements Comparable<Dot>{
		int value;
		int idx;
		int cnt;
		public Dot(int v,int i,int c) {
			this.value = v;
			this.idx = i;
			this.cnt = c;
		}
		
		@Override
	    public int compareTo(Dot target) {
	        if (this.cnt > target.cnt) {
	            return 1;
	        } else if (this.cnt < target.cnt) {
	            return -1;
	        }else if (this.cnt == target.cnt) {
	        	if(this.idx < target.idx) return 1;
	        	else return -1;
	        }
	        return 0;
	    }
		
	}
}
