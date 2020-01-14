package Expert;

import java.util.Scanner;

public class RE4012 {
	static int n, ans;
	static int arr[][];
	static boolean v[];
	public static void dfs(int k,int cnt) {
		v[k] = true;
		for(int i=0;i<n;i++) {
			System.out.print(v[i]+" ");
		}
		if(cnt == n/2) {
			int a = 0;
			int b = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j) continue;
					if(v[i]&&v[j]) a+= arr[i][j];
					if(!v[i]&&!v[j]) b+= arr[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(a-b));
		}
		else {
			for(int i=k+1;i<n;i++) {
				System.out.println("dfs("+i+","+(cnt+1)+")");
				dfs(i,cnt+1);
			}
			
		}
		
		v[k] = false;
		//System.out.println("v["+k+"]: "+v[k]);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			arr = new int[n][n];
			v = new boolean[n];
			ans = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			dfs(0,1);
			System.out.println("#"+t+" "+ans);
		}
	}
}
