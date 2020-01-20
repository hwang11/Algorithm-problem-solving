package BOJ;
import java.util.*;
public class BOJ1167 {
	static int v;
	static int arr[][] = new int[v][v];
	static int count = 0;
	static int ans = 0;
	static boolean visited[];
	public static void dfs(int x) {
		System.out.println("x:"+x);
		visited[x] = true;
		for(int i=1;i<=v;i++) {
			if(arr[x][i] == arr[i][x] && arr[x][i]!=0 && visited[i] == false) {
				count += arr[x][i];
				System.out.println("arr["+x+"]["+i+"]:"+arr[x][i]);
				ans = Math.max(ans, count);
				visited[i] = true;
				System.out.println();
				dfs(i);
			}
			else continue;
		}
		ans-=count;
		visited[x] = false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		arr = new int[v+1][v+1];
		visited = new boolean[v+1];
		for(int i=0;i<v;i++) {
			int s = sc.nextInt();
			while(true) {
				int a = sc.nextInt();
				if(a == -1) break;
				else {
					int e =	a;
					int d = sc.nextInt();
					arr[s][e] = d;
					arr[e][s] = d;
				}
			}
		}
		dfs(1);
		System.out.println("ans:"+ans);
	}
	
}
