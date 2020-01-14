package Expert;

import java.util.Scanner;
//순열ㅂ 배열로 할 생각을 못하고 처음엔 리스트로 생각햇당... 
public class RE4008 {
	static int n,ans,min,max;
	static int c[];
	static int arr[];	
	static void dfs(int cnt,int num) {
		if(cnt==n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}else {
			if(c[0]!=0) {
				c[0]--;
				dfs(cnt+1,num+arr[cnt]);
				c[0]++;
			}
			if(c[1]!=0) {
				c[1]--;
				dfs(cnt+1,num-arr[cnt]);
				c[1]++;
			}
			if(c[2]!=0) {
				c[2]--;
				dfs(cnt+1,num*arr[cnt]);
				c[2]++;
			}
			if(c[3]!=0) {
				c[3]--;
				dfs(cnt+1,num/arr[cnt]);
				c[3]++;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			c = new int[4];
			arr = new int[12];
			ans = 0;
			for(int i=0;i<4;i++) {
				c[i] = sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			max = -Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			dfs(1,arr[0]);
			ans = max - min;
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}
