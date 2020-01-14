package han;

import java.util.Scanner;

public class B1475 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int arr[] = new int[10];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-48]++;
		}
		int ans = 0;
		int max = 0;
		int num = 0;
//		if(arr[9]%2!=0) {
//			arr[9] = (arr[9]+arr[6])/2 +1;
//		}
//		else if(arr[9]!=0) arr[9] = (arr[9]+arr[6])/2;
//		
//		if(arr[6]%2!=0) {
//			arr[6] = ((arr[9]+arr[6])/2 +1);
//		}
//		else if(arr[6]!=0) arr[6] = (arr[9]+arr[6])/2;
		int sum = arr[6]+arr[9];
		if(sum%2!=0) {
			sum = (sum/2 +1);
		}
		else if(sum!=0) sum = (sum)/2;
		arr[6] = sum;
		arr[9] = 0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				num = i;
				max = arr[i];
			}
		}
		ans = max;
		System.out.println(ans);
	}
}
