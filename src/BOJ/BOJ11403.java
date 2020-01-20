package BOJ;
import java.util.*;
public class BOJ11403 {
	static int[] visited = new int[100];
	static int a[][] = new int[100][100];

	public static void dfs(int sv) {
		for(int i=0;i<a.length;i++) {
			if(a[sv][i]==1&&visited[i]==0) {
				visited[i]=1;
				dfs(i);	
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int b[][] = new int[100][100];
		

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=scan.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			dfs(i);
			for(int j=0;j<n;j++) {
				b[i][j]=visited[j];
			}
			Arrays.fill(visited, 0);
		}
		

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
			
	}
}
