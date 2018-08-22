package practice29;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E1953 {
	static boolean v[][];
	static int map[][];
	static int n,m,r,c,l;
	static int diy[] = {0,0,-1,1};
	static int dix[] = {1,-1,0,0};
	static int cnt;
	//static int len;
	static Queue<Dot> q;
	
	public static boolean check(int y,int x) {
		if(y<n && y >= 0 && x<m && x >=0 && map[y][x] > 0 && v[y][x] == false) {
			return true;
		}
		else return false;
	}
	
	public static void dfs(int y,int x,int len) {
		if(len == l) {
			return;
		}
		else {
			if(map[y][x] == 1) {
				for(int j=0;j<4;j++) {
					int my = diy[j] + y;
					int mx = dix[j] + x;
					if(my<n || my >= 0 || mx<m || mx >=0) continue;
					dfs(my,mx,len+1);
					System.out.println(my+","+mx);
				}
			}
			else if(map[y][x] == 2) {
				int my = y + 1;
				int mx = x;
				if(check(my,mx)) {
					dfs(my,mx,len+1);
					System.out.println(my+","+mx);
				};
				
				int my2 = y - 1;
				int mx2 = x;
				if(check(my2,mx2)) {
					dfs(my2,mx2,len+1);
					System.out.println(my2+","+mx2);
				}
			}
			else if(map[y][x] == 3) {
				int ny = y;
				int nx = x - 1;
				if(check(ny,nx)) {
					dfs(ny,nx,len+1);
					System.out.println(ny+","+nx);
				}
				
				int ny2 = y;
				int nx2 = x + 1;
				if(check(ny2,nx2)) {
					dfs(ny2,nx2,len+1);
					System.out.println(ny2+","+nx2);
				};
			}
			else if(map[y][x] == 4) {
				int y2 = y + 1;
				int x2 = x;
				if(check(y2,x2)) {
					dfs(y2,x2,len+1);
					System.out.println(y2+","+x2);
				};
				
				int y3 = y;
				int x3 = x + 1;
				if(check(y3,x3)) {
					System.out.println(y3+","+x3);
				};
			}
			else if(map[y][x] == 5){
				int y4 = y - 1;
				int x4 = x;
				if(check(y4,x4)) {
					dfs(y4,x4,len+1);
					System.out.println(y4+","+x4);
				}
				
				int y5 = y;
				int x5 = x + 1;
				if(check(y5,x5)) {
					dfs(y5,x5,len+1);
					System.out.println(y5+","+x5);
				};
			}
			else if(map[y][x] == 6){
				int y6 = y - 1;
				int x6 = x;
				if(check(y6,x6)) {
					dfs(y6,x6,len+1);
					System.out.println(y6+","+x6);
				}
				
				int y7 = y;
				int x7 = x - 1;
				if(check(y7,x7)) {
					dfs(y7,x7,len+1);
					System.out.println(y7+","+x7);
				}
			}
			else if(map[y][x] == 7){
				int y8 = y + 1;
				int x8 = x;
				if(check(y8,x8)) {
					q.add(new Dot(y8,x8));
					cnt++;
					v[y8][x8] = true;
					System.out.println(y8+","+x8);
				}
				
				int y9 = e.y;
				int x9 = e.x - 1;
				if(check(y9,x9)) {
					q.add(new Dot(y9,x9));
					cnt++;
					v[y9][x9] = true;
					System.out.println(y9+","+x9);
				}
			}
		}
		
		--len;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<=t;i++) {
			v = new boolean[100][100];
			map = new int[100][100];
			n = sc.nextInt();
			m = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			l = sc.nextInt();
			
			for(int j=0;j<5;j++) {
				for(int k=0;k<6;k++) {
					map[j][k] = sc.nextInt();
				}
			}
			System.out.println(cnt);
			
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
