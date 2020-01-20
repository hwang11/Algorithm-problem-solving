package BOJ;
import java.util.*;
public class InsertionSort {
	public static void main(String args[]) {
		int arr[] = {5,3,4,7,2,8,6,9,1};
		int stan;
		for(int i=1;i<arr.length;i++) {
			stan = arr[i];//기준.
			int aux = i - 1;//비교할 대상의 index.
			
			while(aux >=0 && stan <arr[aux]) {
				arr[aux+1] = arr[aux];
				aux--;
			}
			arr[aux+1]=stan;
			
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);

		}
		
	}
}
