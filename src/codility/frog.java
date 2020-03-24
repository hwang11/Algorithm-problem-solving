package codility;
//O(1)
public class frog {
	public static int solution(int X, int Y, int D) {
		// write your code in Java SE 8
		if(X == Y) return 0;
		int ans = 0;
		int r = Y-X;
		if(r%D==0) ans = r/D;
		else ans = (r/D)+1;
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(10,20,30));
	}
}
