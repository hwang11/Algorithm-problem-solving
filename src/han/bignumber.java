package han;

import java.util.Arrays;
import java.util.Comparator;

public class bignumber {
	public static String solution(int[] numbers) {
        String answer = "";
        String arr[] = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) arr[i] = Integer.toString(numbers[i]);
        //int -> string Integer.toString(숫자 );
        //string -> int Integer.parseInt(문자);
        Arrays.sort(arr,new numComparator());
        for(int i=arr.length-1;i>=0;i--) answer += arr[i];
        if(arr[arr.length-1].equals("0")) answer = "0";
        return answer;
    }
	public static void main(String args[]) {
		int a[] = {3, 30, 34, 5, 9}; //9534330
		solution(a);
		//첫째자리수가 같으면 그 다음껄 비교 그다음께 같으면 그 다음자리 비교 
	}
	static class numComparator implements Comparator<String>{
		@Override
		public int compare(String a,String b) {
			String t1 = a+b;
			String t2 = b+a;
			if(t1.compareTo((t2))>0) return 1;
			else if(t1.compareTo(t2)<0) return -1;
			else return 0;
		}
		
	} 
}
