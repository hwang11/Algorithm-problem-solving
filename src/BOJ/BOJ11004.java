package practice13;
import java.util.*;
import java.io.*;
//시간 줄여야하는문제 InputStream사용.
public class BOJ11004 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.sort(arr);
		System.out.println(arr[K-1]);
	}
}
