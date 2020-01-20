package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206 {
	static int n,m,ans;
	static char map[][];
	static boolean v[][][];
	static boolean flag;
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
//	static void print() {
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				if(v[i][j][0]) System.out.print(2+"");
//				else System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("--------------------");
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				if(v[i][j][1]) System.out.print(2+"");
//				else System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(1,1,0,0));
		v[1][1][0] = true;
		v[1][1][1] = true;
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			//System.out.printf("dot %d,%d c:%d 부숨: %d\n",dot.y,dot.x,dot.c,dot.des);
			if(dot.x == m && dot.y == n) {
				System.out.println("여기 ");
				ans = Math.min(dot.c+1, ans);
				return;
			}
			for(int i=0;i<4;i++) {
				int ny = dot.y + dr[i][0];
				int nx = dot.x + dr[i][1];
				if(ny < 1 || nx < 1|| ny > n || nx > m) continue;
				if(map[ny][nx] == '1') {
					if(v[ny][nx][1]) continue;
					if(dot.des<1) { //안 부수고 쭉 왔다면 이제 부실차례 
						System.out.printf("%d %d\n",ny,nx);
						v[ny][nx][1] = true;
		 				q.add(new Dot(ny,nx,dot.c+1,1));
					}
					continue;
				}else {
					if(v[ny][nx][dot.des]) continue;
					v[ny][nx][dot.des] = true;
	 				q.add(new Dot(ny,nx,dot.c+1,dot.des));
				}
				
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n+1][m+1];
		v = new boolean[n+1][m+1][2];
		flag = false;
		String s = sc.nextLine();
		for(int i=1;i<=n;i++) {
			s = sc.nextLine();
			//System.out.println("s"+s);
			for(int j=1;j<=m;j++) {
				map[i][j] = s.charAt(j-1);
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
	}
	static class Dot{
		int y;
		int x;
		int c;
		int des;
		public Dot(int y,int x,int c,int des) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.des = des;
		}
	}
}
