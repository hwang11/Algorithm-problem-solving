package BOJ;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class B15685 {
	static int N,ans;
	static int dr[][] = {{1,0},{0,-1},{-1,0},{0,1}}; //x,y
	static boolean v[][];
	static Stack<Integer> st[]; 
	static LinkedList<Integer> li[];
	static void draw(int x1,int y1,int d,int g, int idx) {
		int x = x1;
		int y = y1;
		v[y][x] = true;
		li[idx].add(d);
		st[idx].push(d);
		int nx = x + dr[d][0];
		int ny = y + dr[d][1];
		v[ny][nx] = true;
		for(int i=0;i<g;i++) {
			int size = st[idx].size();
			for(int k=0;k<size;k++) {
				int p = st[idx].pop();
				int nd = (p + 1)%4;
				nx = nx + dr[nd][0];
				ny = ny + dr[nd][1];
				v[ny][nx] = true;
				li[idx].add(nd);
			}
			for(int j=0;j<li[idx].size();j++) {
				st[idx].push(li[idx].get(j));
			}

		}
	}
	static boolean chk(int x,int y) { // 1x1 정사각형 확인 
		if(!v[y][x] || !v[y][x+1] || !v[y+1][x] || !v[y+1][x+1]) return false;
		return true;
	}
	static int count() {
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(chk(i,j)) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		st = new Stack[N];
		li = new LinkedList[N];
		v = new boolean[101][101]; //x,y 범위가 100까지 였음. x,y <= 100 
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			li[i] = new LinkedList<Integer>();
			st[i] = new Stack<Integer>();
			draw(x,y,d,g,i);
		}
		ans = count();
		System.out.println(ans);
	}
}
