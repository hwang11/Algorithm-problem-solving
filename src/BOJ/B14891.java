package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B14891 {
	static int k,ans;
	static char a[][];
	static LinkedList<Character> li[];
	static boolean check(int a, int b) {
 		if(a<1 || a>4 || b<1 || b>4) return false;
		if(a<b) {
			if(li[a].get(2) == li[b].get(6)) return false; //
			else return true;
		}
		else {
			if(li[a].get(6) == li[b].get(2)) return false; //
			else return true;
		}
	}
	static void left(int num,int d) {
		if(num<1 || num>4) return;
		if(check(num-1,num)) {
			left(num-1,-d);
			rotate(num-1,-d);
		}
	}
	static void right(int num,int d) {
		if(num<1 || num>4) return;
		if(check(num+1,num)) {
			right(num+1,-d);
			rotate(num+1,-d);
		}
	}
	
	static void rotate(int num,int d) {
		System.out.printf("rotate %d\n",num);
		if(d>0) li[num].addFirst(li[num].pollLast());
		else li[num].addLast(li[num].pollFirst());
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		li = new LinkedList[5];
		for(int i=1;i<=4;i++) {
			String s = sc.nextLine();
			li[i] = new LinkedList<Character>();
			for(int j=0;j<8;j++) {
				li[i].add(s.charAt(j));				
			}
		}
		k = sc.nextInt();
		for(int i=0;i<k;i++) {
			int num = sc.nextInt();
			int d = sc.nextInt();
			left(num,d);
			right(num,d);
			rotate(num,d);
		}
		ans = 0;
		for(int i=1;i<=4;i++) {
			if(li[i].get(0) == '1') {
				ans += Math.pow(2, i-1);
			}
		}
		System.out.println(ans);
	}
}
