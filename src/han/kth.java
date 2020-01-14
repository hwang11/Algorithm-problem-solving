package han;

import java.util.Arrays;

public class kth {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int j=0;j<commands.length;j++) {
        	int [] a = new int[commands[j][1]-commands[j][0]+1];
        	idx = 0;
        	for(int i=commands[j][0]-1;i<commands[j][1];i++) a[idx++] = array[i];
        	Arrays.sort(a);
        	answer[j] = a[commands[j][2]-1];
        }
        return answer;
    }
	public static void main(String args[]) {
		int a[] = {1, 5, 2, 6, 3, 7, 4};
		int b[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(a,b);
	}
}
