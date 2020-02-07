package BOJ;

import java.util.Scanner;
//가장 많이 등장한 숫자 출력 
public class manynum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String s = Integer.toString(num); //int로 들어오면 string으로 변환해서 푸는게 더 간단하다. 
		int arr[] = new int[10];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-48]++;
		}
		int max = 0;
		int ans = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
