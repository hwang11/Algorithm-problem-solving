package codility;

public class ReplacingBooks {
	public static int solution(int[] A, int K) {
        // write your code in Java SE 8
		if(K==0) {
			
		}
		return 0;
    }
	public static void main(String[] args) {
		/*1, 1, 3, 4, 3, 3, 4] k = 2 ans 5
		 * 4, 5, 5, 4, 2, 2, 4 k = 0 ans 2 
		 * 1, 3, 3, 2 k=2 ans 4*/
		//연속해야하므로 순서 가 중요하다 
		int a[] = {1, 1, 3, 4, 3, 3, 4};
		int b[] = {4, 5, 5, 4, 2, 2, 4};
		int c[] = {1, 3, 3, 2};
		solution(a,2);
		solution(b,0);
		solution(c,2);
	}
}
