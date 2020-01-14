package Asamsung;

import java.util.LinkedList;
import java.util.Scanner;

public class B11559 {
	static boolean flag;
	static int ans;
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static char map[][];
	static boolean v[][];
	static LinkedList<Dot> li = new LinkedList<Dot>();
	static void down() {
		for(int i=0;i<6;i++) {
			for(int j=11;j>0;j--) {
				if(map[j][i] == '.') {
					for(int y=j-1;y>=0;y--) {
						if(map[y][i] != '.') {
							map[j][i] = map[y][i];
							map[y][i] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	static void boom() {
		for(int i=0;i<li.size();i++) {
			map[li.get(i).x][li.get(i).y] = '.';
		}
	}
	static void dfs(int x,int y,char ch) {
		for(int i=0;i<4;i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if(ny < 0 || nx < 0 || nx >=12 || ny >=6) continue;
			if(v[nx][ny]) continue;
			if(map[nx][ny] == '.') continue;
			if(ch == map[nx][ny]) {
				li.add(new Dot(nx,ny));
				v[nx][ny] = true; 
				dfs(nx,ny,ch);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		//String a = sc.nextLine();
		for(int i=0;i<12;i++) {
			String s = sc.nextLine();
			for(int j=0;j<6;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		ans = 0;
		while(true) {
			flag = false;
			v = new boolean[12][6];
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(!v[i][j] && map[i][j]!='.') {
						dfs(i,j,map[i][j]);
						if(li.size()>=4) {
							flag = true;
							boom();
						}
						li.clear();
					}
				}
			}
			if(!flag) break;
			else ans++;
			down();
		}
		System.out.println(ans);
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
