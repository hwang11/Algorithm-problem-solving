package aaa;

import java.util.LinkedList;
import java.util.Scanner;
/*순열문제
 * 추가==============
2 1 (리스트)
1 1 0 0 (visit배열)
<<<<<<<<결과>>>>>>>>
(2 1 ) => 리스트에 추가된 순서! 
<1 2 > => visit배열의 true인 인덱스를 출력한 것. 이것은 인덱스 순서대로 나오기 때문에 리스트에 담겨있는 수와 다르다!!!!!! 
 *이 때문에 visit배열의 인덱스를 출력하는 것은 답이 안나왔던 것! 
 *
 **/
public class R15649 {
	static int n,m;
	static LinkedList<Integer> li;
	static boolean v[];
	static void print() {
		for(int i=0;i<li.size();i++) System.out.print(li.get(i)+" ");
		System.out.println();
		for(int i=1;i<=n;i++) {
			if(v[i]) System.out.print(1+" ");
			else System.out.print(0+" ");
		}
		System.out.println();
	}
	public static void dfs(int cnt) {
		if(cnt == m) {
			System.out.println("<<<<<<<<결과>>>>>>>>");
			System.out.print("(");
			for(int i=0;i<li.size();i++) {
				if(v[li.get(i)]) {
					System.out.print(li.get(i)+" ");
				}
			}
			System.out.print(")");
			System.out.println();
			System.out.print("<");
			for(int i=1;i<=n;i++) {
				if(v[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.print(">");
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			if(!v[i]) {
				v[i] = true;
				li.add(i);
				System.out.println("추가==============");
				print();
				dfs(cnt+1);
			
				v[i] = false;
				System.out.println("삭제=====================");
				li.removeLast();
				print();
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		li = new LinkedList<Integer>();
		v = new boolean[n+1];
		dfs(0);
	}
}
