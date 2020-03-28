package codility;

//o(N)
public class TapeEquilibrium {
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int sum[] = new int[A.length];
		sum[0] = A[0];
		for(int i=1;i<A.length;i++) {
			sum[i] = sum[i-1]+A[i];
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A.length-1;i++) {
			int d = Math.abs(sum[i]-(sum[A.length-1]-sum[i]));
			min = Math.min(d, min);
		}
		return min;
    }
	public static void main(String[] args) {
/*
 * A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3*/
		int a[] = {3,1,2,4,3};
		System.out.println(solution(a));
	}
}
