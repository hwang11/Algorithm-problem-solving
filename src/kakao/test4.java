package kakao;

public class test4 {
	static public int solution(int[] food_times, long k) {
		int p = 0;
		while(k>0) {
			p%=food_times.length;
			if(food_times[p] != 0) {
				--k;
				food_times[p]--;
			}
			++p;
		}
        int answer = 0;
        answer = (p%food_times.length)+1;
        return answer;
    }
	public static void main(String args[]) {
		int a[] = {3,1,2,1};
		long k = 5;
		System.out.println(solution(a,k));
	}
}
