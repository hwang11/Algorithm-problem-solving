package aaa;

public class b3 {
	public static int solution(int[] sticker) {
		int answer = 180;
		int[] dp1 = new int[100001];
	    int[] dp2 = new int[100001];
		int m = sticker.length;
	    if(m==1) return sticker[0];
	    dp1[0] = sticker[0];
	    dp1[1] = dp1[0];
	 
	    for(int i=2;i<m;i++){
	        dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
	    }
        dp2[0] = 0;
	    dp2[1] = sticker[1];
	 
	    for(int i=2;i<m;i++){
	        dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
	    }
	    answer = Math.max(dp1[m-1],dp2[m-1]);
		return answer;
	}
	public static void main(String[] args) {
		int a[] = {12, 12, 12, 12, 12};
		int b[] = {12, 80, 14, 22, 100};	
		solution(a);
		solution(b);
	}
}
