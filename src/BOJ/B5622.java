package BOJ;

import java.util.Scanner;

//2:35-
public class B5622 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		String s = sc.nextLine();
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			//System.out.printf("%d %c\n",s.charAt(i)-65,s.charAt(i));
			sum += arr[s.charAt(i)-65]+1;
		}
		System.out.println(sum);
		
	}
}
