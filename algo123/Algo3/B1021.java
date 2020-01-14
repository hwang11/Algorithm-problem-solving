package Algo3;


import java.util.LinkedList;
import java.util.Scanner;

public class B1021 {
	static int n,m;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		LinkedList li = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			li.add(i);
		}
		m = sc.nextInt();
		int num[] = new int[m];
		for(int i=0;i<m;i++) {
			num[i] = sc.nextInt();
		}
		int cnt = 0;
		for(int i=0;i<m;i++) {
			while(true) {
				int pos = li.indexOf(num[i]);
				int left = pos;
				int size = li.size();
				int right = size - pos - 1;
				
				if(left == 0) {
					li.removeFirst();
					break;
				}
				else if(left <= right) {
					cnt++;
					li.addLast(li.removeFirst());
				}
				else {
					cnt++;
					li.addFirst(li.removeLast());
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
