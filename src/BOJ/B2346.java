package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B2346 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer(); 
		LinkedList<Dot> li = new LinkedList<Dot>();
		for(int i=1;i<=n;i++) {
			int v = sc.nextInt();
			li.add(new Dot(v,i));
		}
		int size = li.size();
		int kill=0; int val = 0;
		while(n>0) {
			if(val>0) {
				for(int i=0;i<val-1;++i) {
					++kill;
					if(kill>=li.size()) {
						kill = 0;
					}
				}
			}else if(val<0) {
				val*=-1;
				for(int i=0;i<val;++i) {
					--kill;//왼쪽으로.
					if(kill<0) {
						kill=li.size()-1;
					}
				}
			}
			Dot d = li.get(kill);
			val = d.value;
			sb.append(d.num+" ");
			li.remove(kill);
			if(kill==li.size()) {
				kill = 0;
			}
			n--;
		}
		System.out.println(sb);
	}
	public static class Dot{
		int value;
		int num;
		public Dot(int v,int n) {
			this.value = v;
			this.num = n;
			
		}
	}
}
