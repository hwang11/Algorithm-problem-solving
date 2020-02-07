package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13913 {
	static int k,n;
	static int cnt;
	static int v[];
	static int dr[] = {1,-1};
	static ArrayList <Integer> list;
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		list = new ArrayList<Integer>();
		int x = n;
		q.add(n);
		v[n] = n;
		int nx = 0;
			int size = q.size();
			while(size>0) {
				x = q.poll();
				if(x==k) {
					int pre = k;
					while(pre!=n) { //k에서 n으로 가는 과정.
						list.add(pre);
						pre = v[pre];
					}
					System.out.println(list.size());
					System.out.print(n+" ");
					for(int i=list.size()-1;i>=0;i--) {
						System.out.print(list.get(i)+" ");
					}
					return;
				}
				for(int i=0;i<3;i++) {
					if(i == 2) {
						nx = x*2;
					}
					else nx = x+dr[i];
					if(nx > 100000 || nx<0) continue;
					if(v[nx]!=-1) continue;
					v[nx] = x;
					q.add(nx);
				}
			}
		
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		v = new int[100002];
		for(int i=0;i<v.length;i++) v[i] = -1;
		
		bfs();
		
	}
}
