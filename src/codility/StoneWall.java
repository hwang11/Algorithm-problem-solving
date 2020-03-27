package codility;

import java.util.Stack;
//O(N)
public class StoneWall {
	public static int solution(int[] H) {
        // write your code in Java SE 8
		  Stack<Integer> stack = new Stack<>();

		  int count = 0;
		  for (int i = 0; i < H.length; i++) {
			System.out.printf("H[%d] : %d\n",i,H[i]);
		    while (!stack.isEmpty() && stack.peek() > H[i]) {
		      stack.pop();
		    }
		    if (stack.isEmpty() || stack.peek() < H[i]) {
		      stack.push(H[i]);
		      count++;
		      System.out.println("push"+H[i]);
		      System.out.println("count:"+count);
		    }
		  }
		  return count;
//		int ans = 0;
//		if(H.length==1 || H.length == 0) return H.length;
//		Stack<Integer> st = new Stack<Integer>();
//		for(int i=0;i<H.length;i++) {
//			
//			int now = H[i];
//			if(st.isEmpty()) {
//				st.push(now);
//			}
//			else { 
//				while(!st.isEmpty() && st.peek() > now) {
//					st.pop();
//					++ans;
//					if(st.isEmpty()) break;
//				}
//				if(!st.isEmpty() && st.peek() == now) continue;
//				st.push(now);
//			}
//		}
//		ans += st.size();
//		return ans;
    }
	public static void main(String[] args) {
		int a[] = {8,8,5,7,9,8,7,4,8};
		System.out.println(solution(a));
	}
}
