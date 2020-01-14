package practice23;
import java.util.*;
public class BOJ2668 {
	static int n;
	static int a[][];
	static int b[];
	//static boolean visited[]
//	public static void dfs(int x,int y) {
//		
//	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1][n+1];
		b = new int[n+1];
		for(int i=1;i<n;i++) { //1부터시작.
			int v = sc.nextInt();
			a[i][v] = 1;
		}
		//dfs(1,1);
		
		int count = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i][j] == 1 && a[j][i] == 1) {
					count ++;
					b[i-1] = i;
				}
				
			}
		}
		System.out.println(count);
		Arrays.sort(b);
		for(int i=0;i<b.length;i++) {
			if(b[i]!=0) System.out.println(b[i]);
		}
	}
}
