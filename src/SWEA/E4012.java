package Expert;

import java.util.Scanner;

public class E4012 {
	static int n,ans;
	static int arr[][];
	static boolean v[];
//	public static void solve(int cnt,int select) {
//		if(cnt==(n/2)) {
//			int A = 0, B = 0;
//			
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					if(i==j) continue;
//					if(v[i] && v[j]) A+=arr[i][j];
//					if(!v[i] && !v[j]) B+=arr[i][j];
//				}
//			}
//			ans = Math.min(ans, Math.abs(A-B));
//			return;
//		}
//		if(select>0) { //a의 식재료를 고르는 방법.
//			v[cnt] = true;
//			solve(cnt+1,select-1);
//			v[cnt] = false;
//		}
//		solve(cnt+1,select);
//	}
	public static void dfs(int k,int cnt) {
		v[k] = true;
		for(int i=0;i<n;i++) {
			System.out.print(v[i]+" ");
		}
		int A = 0, B = 0;
		if(cnt == n/2) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j) continue;
					if(v[i] && v[j]) A+=arr[i][j];
					if(!v[i] && !v[j]) B+=arr[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(A-B));
			System.out.println("ans: "+ans);
		} // n/2만큼 뽑으면.
		else {
			for(int i=k+1;i<n;i++) {
				System.out.println("dfs("+i+","+(cnt+1)+")");
				dfs(i,cnt+1);
				
			}
		}
		v[k] = false;
		
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			arr = new int[n][n];
			v = new boolean[n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;
			dfs(0,1);
			System.out.println("#"+t+" "+ans);
		}
	}
}
