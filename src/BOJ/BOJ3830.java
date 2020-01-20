package BOJ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ3830 {
	static int n;
	static int m;
	static int sum;
	static int arr[][];
	static boolean c[];
	static boolean d[];
	public static void bfs(int pos) {
		sum = 0;
		c[pos] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(pos);
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=1;i<=n;i++) {
				if(arr[x][i]!=0 && arr[i][x]!=0 && c[i]==false) {
					sum += arr[i][x];
					c[i] = true;
					q.add(i);
				}
				else {
					
				}
			}
		}
		
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			n = sc.nextInt();
			arr = new int[n+1][n+1];
			c = new boolean[n+1];
			d = new boolean[n+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = 0;
				}
			}
			m = sc.nextInt();//일의 수.
			for(int i=0;i<m;i++) {
				String s = sc.next();
				if(s.charAt(0) == '!') {
					int a = sc.nextInt();
					int b = sc.nextInt();
					int w = sc.nextInt();
					d[a] = true;
					d[b] = true;
					arr[b][a] = w;
					arr[a][b] = -w;
				}
				else { // ?
					int a = sc.nextInt();
					int b = sc.nextInt();
					if(d[a] == false || d[b] == false) System.out.println("UNKNOWN");
					else if(arr[a][b] != 0){
						sum = arr[b][a];
						System.out.println(sum);
						sum = 0;
					}else{
						bfs(a);
						Arrays.fill(c, false);
						System.out.println(sum);
					}
				}	
			}
		}

	}
}
