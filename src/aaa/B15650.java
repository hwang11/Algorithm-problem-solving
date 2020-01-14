package aaa;

import java.util.LinkedList;
import java.util.Scanner;
//조합. 리스트를 사용하면 v배열은 의미 없음. 현재인덱스 +1 되도록하는게중요 
public class B15650 {
	static int N, M;
	static LinkedList<Integer> li = new LinkedList<Integer>();
	static boolean v[]; // 4 2 깊이 2 
	static void dfs(int k,int dep) {
		if(dep == M) {
			for(int i=0;i<N;i++) { //전체 중에 방문한것만 꺼내자 
				if(v[i]) System.out.print(i+1+" ");
			}
			System.out.println();
			//return;
		}
		for(int i=k;i<N;i++) { //k와 k+1의 차이 매개변수로 넘어온 k부터 할건지 그 이후부터할건지. 
			if(v[i]) continue; //추가 
			v[i] = true;
			dfs(i+1,dep+1);
			v[i] = false;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N];
		dfs(0,0); //어떨 때는 for문안에 반복이고 어떨때는 한번 호출 => 한번호출로 해결가능! 
	}
}
