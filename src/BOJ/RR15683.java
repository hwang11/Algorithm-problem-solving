package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RR15683 {
	static int n,m,ans;
	static int map[][];
	static int copy[][];
	static int dir[][] = {{0,1},{-1,0},{0,-1},{1,0}};
	static List<Dot> li = new ArrayList<Dot>();
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int cnt) {
		if(cnt >= li.size()) {
			init();
			for(Dot t:li) {
				fill(t);
			}
			int sum = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(copy[i][j] == 0) sum++;
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			li.get(cnt).r = i;//카메라 방향 순열 ? 
			dfs(cnt+1);
		}
	}
	public static void fill(Dot dot) {
		int x,y;
		x = dot.x; 
		y = dot.y;
		switch(dot.n) { //카메라의 넘버에 따라 
		case 1:
			x = dot.x;
			y = dot.y;
			
			while(true) {
				x = x + dir[dot.r][0];
				y = y + dir[dot.r][1];
				if(x < 0 || y < 0 || x>=n || y>=m) break;
				if(copy[x][y] == 6) break;
				else if(copy[x][y] == 0) copy[x][y] = 7;
			}
			break;
		case 2:
			for(int i=0;i<3;i+=2) {
				x = dot.x; //화살표 마다 다시 초기 점에서 시작해야 하므로 초기화 필요 
				y = dot.y;
				while(true) {
					x = x + dir[(dot.r+i)%4][0];
					y = y + dir[(dot.r+i)%4][1];
					if(x < 0 || y < 0 || x>=n || y>=m) break;
					if(copy[x][y] == 6) break;
					else if(copy[x][y] == 0) copy[x][y] = 7;
				}
			}
			break;
		case 3:
			
			for(int i=0;i<2;i++) {
				x = dot.x;
				y = dot.y;
				while(true) {
					x = x + dir[(dot.r+i)%4][0];
					y = y + dir[(dot.r+i)%4][1];
					if(x < 0 || y < 0 || x>=n || y>=m) break;
					if(copy[x][y] == 6) break;
					else if(copy[x][y] == 0) copy[x][y] = 7;
				}
			}
			break;	
		case 4:
			for(int i=0;i<3;i++) {
				x = dot.x;
				y = dot.y;
				while(true) {
					x = x + dir[(dot.r+i)%4][0];
					y = y + dir[(dot.r+i)%4][1];
					if(x < 0 || y < 0 || x>=n || y>=m) break;
					if(copy[x][y] == 6) break;
					else if(copy[x][y] == 0) copy[x][y] = 7;
				}
			}
			break;	
		case 5:
			for(int i=0;i<4;i++) {
				x = dot.x;
				y = dot.y;
				while(true) {
					x = x + dir[(dot.r+i)%4][0];
					y = y + dir[(dot.r+i)%4][1];
					if(x < 0 || y < 0 || x>=n || y>=m) break;
					if(copy[x][y] == 6) break;
					else if(copy[x][y] == 0) copy[x][y] = 7;
				}
			}
			break;	
		}
	}
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		 map = new int[n][m];
		 copy = new int[n][m];
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 map[i][j] = sc.nextInt();
				 if(map[i][j]>0 && map[i][j]<6) li.add(new Dot(i,j,map[i][j],0));
			 }
		 }
		 ans = Integer.MAX_VALUE;
		 dfs(0);
		 System.out.println(ans);
	}
	static class Dot{
		int x;
		int y;
		int n; //카메라 넘버 
		int r; //감시 방향 
		public Dot(int x,int y,int n,int r) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.r = r;
		}
	}
}
