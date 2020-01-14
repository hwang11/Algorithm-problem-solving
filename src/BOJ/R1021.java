package Algo3;

import java.util.LinkedList;
import java.util.Scanner;

public class R1021 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList li = new LinkedList<Integer>();
		int num[] = new int[m];
		for(int i=0;i<m;i++) {
			num[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			li.add(i);
		}
		
		int cnt = 0;
		for(int i=0;i<m;i++) {
			while(true) {
				int left = li.indexOf(num[i]);
				int pos = left;
				int size = li.size();
				int right = size - pos - 1;
				if(left == 0) {
					li.removeFirst();
					break;
				}
				else if(left <= right) {
					li.addLast(li.removeFirst());
					cnt++;
				}
				else {
					li.addFirst(li.removeLast());
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
