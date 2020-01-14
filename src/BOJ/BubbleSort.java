package practice13;
import java.util.*;
public class BubbleSort {
	public static void main(String args[]) {
		int arr[] = {5,3,8,1,9,4};
		int tmp;
		for(int j=0;j<arr.length-1;j++) {
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
				}
			}		
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

	}
}
