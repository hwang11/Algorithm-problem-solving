package Expert;

import java.util.Scanner;

public class RRE2112 {
	static int D,W,K,ans;
	static boolean flag;
	static int a[][];
	public static boolean check() {
		for(int i=0;i<W;i++) {
			int total = 0,cnt = 1,curr = a[0][i];
			for(int j=1;j<D;j++) {
				if(curr == a[j][i]) cnt++;
				else {
					total = (cnt>total)? cnt : total;
					cnt = 1;
					curr = a[j][i];
				}
			}
			total = (cnt>total)? cnt : total;
			if(total<K) return false;
		}
		return true;
	}
	public static void dfs(int depth,int pos,int aim) {
		if(flag) return;
		if(depth == aim) {
			if(check()) {
				flag = true;
			}
			return; 
		}
		int tmp[][] = new int[1][21];
		for(int i=pos;i<D;i++) {
			for(int j=0;j<=1;j++) {
				for(int k=0;k<W;k++) {
					tmp[0][k] = a[i][k];
					a[i][k] = j;
				}
				dfs(depth+1,i+1,aim);
				for(int k=0;k<W;k++) {
					a[i][k] = tmp[0][k];
				}
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			a = new int[D][W];
			flag = false;
			for(int i=0;i<D;i++) {
				for(int j=0;j<W;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<D;i++) // 젤마니해도 전체 행 만큼이라서.
			{
				dfs(0,0,i);
				if(flag) {
					ans = i;
					break;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
}
