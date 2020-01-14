package Algo10;


import java.util.LinkedList;
import java.util.Scanner;

public class bru14501 {
	static int n, ans;
	static int t[], p[];
	static LinkedList<Integer> li = new LinkedList<Integer>();
	public static void dfs(int idx, int sum) {
		if (idx == n + 1) {
			ans = Math.max(sum, ans);
			System.out.print("완성 return ");
			for(int i=0;i<li.size();i++) {
				System.out.printf(li.get(i)+" ");
			}
			System.out.println();
			li.clear();
			return;
		}
		if(idx + t[idx] <= n+1) {
			li.add(idx);
			System.out.printf("dfs1 %d + %d, sum: %d\n",idx,t[idx],(sum+p[idx]));
			dfs(idx + t[idx],sum+p[idx]);
			System.out.println("return 됨 ");
		}
		System.out.printf("두번째 dfs(%d + %d, sum: %d) 다음날로 넘어가자 \n",idx,1,sum);
		dfs(idx+1,sum); //조건 안되면상담하지 않고 그냥 다음날로 넘어감 
		System.out.println("끝까지 옴 return");
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n + 1];
		p = new int[n + 1];
		ans = 0;
		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		dfs(1, 0);
		System.out.println(ans);
	}
}
