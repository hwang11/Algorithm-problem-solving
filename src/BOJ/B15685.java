package BOJ;

import java.util.Scanner;

public class B15685 {
	static int n;
	static boolean v[][];
	static int dr[][] = {{1,0},{0,-1},{-1,0},{0,1}}; //x,y 우 상 좌 하 
	static void print() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(v[i][j]) System.out.print(1+"");
				else System.out.print(0+"");
			}
			System.out.println();
		}
	}
	static void dfs(int x,int y,int d,int g,int cnt) {
		System.out.printf("x:%d y:%d\n",x,y);
		v[y][x] = true;
		if(cnt == g+1) {
			return;
		}
		int nx = x + dr[d][0];
		int ny = y + dr[d][1];
		
		d--;
		d+=4;
		d%=4;
		dfs(nx,ny,d,g,cnt+1);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		v = new boolean[101][101];
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			dfs(x,y,d,g,0);
			print();
		}
		
	}
}
