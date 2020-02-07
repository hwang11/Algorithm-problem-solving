package BOJ;

public class hindex {
	public static int solution(int[] arr) {
        int answer = 0;
        int cnt1 = 0; int cnt2 = 0;
        for(int i=0;i<arr.length;i++) {
        	cnt1 = 0; cnt2 = 0;
        	for(int j=0;j<arr.length;j++) {
        		if(arr[j]>=(i+1)) cnt1++;
            	if(arr[j]<=(i+1)) cnt2++;
        	}
        	if(cnt1 >= (i+1) && cnt2 <= (i+1)) answer = (i+1);
        }
        System.out.println(answer);
        return answer;
    }
	public static void main(String args[]) {
		int a[] = {3, 0, 6, 1, 5};
		solution(a);
	}
}
