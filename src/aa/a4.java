package aa;
//누적합 배열을 이용하여 구현 
public class a4 {
	static int[] answer;
	static int[] sum;
	static int plus(int s,int e) {
		return sum[e] - sum[s-1];
	}
    public static int[] solution(int[] numbers, int[] start, int[] finish) {
        answer = new int[start.length];
        sum = new int[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	if(i==0) sum[0] = numbers[0];
        	else sum[i] = sum[i-1] + numbers[i];
        }
        for(int i=0;i<start.length;i++) {
        	answer[i] = plus(start[i],finish[i]);
        }
        for(int i=0;i<answer.length;i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }
	public static void main(String[] args) {
//[100, 101, 102, 103, 104]	[1, 2]	[2, 4]
		int a[]= {100, 101, 102, 103, 104};
		int s[] = {1,2};
		int e[] = {2,4};
		solution(a,s,e);
	}
}
