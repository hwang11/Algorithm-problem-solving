package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B2580 {
	static int a[][];
	static LinkedList<Dot> li;
	public static boolean row(int y,int k) {
		for(int i=0;i<9;i++) {
			if(k == a[y][i]) {
				//System.out.println(k);
				return false;
			}
		}
		return true;
	}
	public static boolean col(int x,int k) {
		for(int i=0;i<9;i++) {
			if(k == a[i][x]) {
				return false;
			}
		}
		return true;
	}
	public static boolean box(int y,int x,int k) {
		int y1 = y/3;
		int c = y1*3;
		int x1 = x/3;
		int r = x1*3;
		for(int i=c;i<c+3;i++) {
			for(int j=r;j<r+3;j++) {
				if(k == a[c][r]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void dfs(int cnt) {
		//System.out.println(cnt);
		if(cnt == li.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		for(int k=1;k<=9;k++) {
			int x = li.get(cnt).x;
			int y = li.get(cnt).y;
			if(row(y,k)&&col(x,k)&&box(y,x,k)) {
				//System.out.println("tre");
				a[y][x] = k;
				dfs(cnt+1);
				a[y][x] = 0;

			}
		}
	
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		li = new LinkedList<Dot>();
		a = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] == 0) {
					li.add(new Dot(i,j));
				}
			}
		}
		for(int k=1;k<=9;k++) {
			int x = li.get(0).x;
			int y = li.get(0).y;
			if(row(y,k)&&col(x,k)&&box(y,x,k)) {
				a[y][x] = k;
				dfs(1);
				a[y][x] = 0;

			}
		}
		
	}
	public static class Dot{
		int y;
		int x;
		
		public Dot(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
