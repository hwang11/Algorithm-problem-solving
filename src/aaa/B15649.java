package aaa;

import java.util.LinkedList;
import java.util.Scanner;
//순열 
public class B15649 {
	static int N, M;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static boolean v[]; // 4 2 깊이 2 
	static void dfs(int dep,int k) {
		//System.out.println("dep:"+dep+" k:"+k);
		if(dep == M) {
			for(int i=0;i<N;i++) { //전체 중에 방문한것만 꺼내자 
				if(v[i]) System.out.print(i+1+" ");
			}
			System.out.println();
		}
		for(int i=0;i<N;i++) { //k와 k+1의 차이 매개변수로 넘어온 k부터 할건지 그 이후부터할건지. 
			if(v[i]) continue; //추가 
			v[k] = true;
			dfs(dep+1,i);
			v[k] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N];
		dfs(0,0);
	}
}
