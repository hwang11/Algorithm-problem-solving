package practice32;

import java.util.Scanner;

public class RBOJ6603 {
	static int k,cnt;
	static int a[];
	static StringBuffer sb = new StringBuffer();
	public static void dfs(int v,int cnt,String s) {
		if(cnt == 6) {
			sb.append(s+"\n");
		}
		else {
			for(int i=v+1;i<k;i++) {
				dfs(i,cnt+1,s+a[i]+" ");
			}
		}
	}
//	public static void dfs(int v,int cnt,String s) {
//		if(cnt == 6) {
//			sb.append(s+"\n");
//		}else {
//			dfs(v+1,cnt+1,s+a[v+1]+" ");
//			dfs(v,cnt+1,s+a[cnt+1]+" ");
//		}
//	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while((k=sc.nextInt())!=0) {
			a = new int[k];
			for(int i=0;i<k;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0;i<k;i++) {
				cnt = 1;
				dfs(i,cnt,a[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
