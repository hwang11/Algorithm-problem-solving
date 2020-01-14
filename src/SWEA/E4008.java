package Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E4008 {
	static int n,ans,min,max,value;
	static ArrayList<String> li;
	static int arr[];
	static int c[];

	static void dfs(int cnt,int num) {
		if(cnt==n) {
			System.out.println("완성 ");
			System.out.println();
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		else {
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
		System.out.println("return ");
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			li = new ArrayList<String>();
			arr = new int[5];
			c = new int[4];
			for(int i=0;i<4;i++) {
				c[i] = sc.nextInt();
				
			}
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
			max = -Integer.MAX_VALUE;
			dfs(1,arr[0]);
			ans = max - min;
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}
