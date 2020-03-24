package codility;

public class arr {
	//O(N) or O(N * log(N))
	public static int solution(int[] A) {
        // write your code in Java SE 8
//		if(A.length==0) return 0;
		boolean v[] = new boolean[A.length+2];
		for(int i=0;i<A.length;i++) {
			int num = A[i];
			v[num] = true;
		}
		for(int i=1;i<=A.length;i++) {
			if(!v[i]) return i;
		}
		return A.length+1;
    }
	public static void main(String[] args) {
		int[] a = {2,3,1,5};
		int[] b = {2};
		int[] c = {};
		System.out.println(solution(a));
		System.out.println(solution(b));
		System.out.println(solution(c));

	}
}
