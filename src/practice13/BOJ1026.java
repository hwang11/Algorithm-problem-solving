package practice13;
import java.util.*;
//두 배열 다 정렬해서 인덱스 거꾸로 곱하면됨..
public class BOJ1026 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int S=0;
		
		for(int i=0;i<N;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			b[i]=sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0;i<N;i++) {
			S+=a[i]*b[N-1-i];
		}
		System.out.println(S);
	}
}
