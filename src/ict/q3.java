package ict;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q3 {
	static int N;
	static char arr[][];
	static boolean v[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(arr[nx][ny] == '0' || v[nx][ny]) continue;
				v[nx][ny] = true;
				q.add(new Dot(nx,ny));
			}
		}
	}
	public static int countGroups(List<String> related) {
		int cnt = 0;
		N = related.size();
		v = new boolean[N][N];
		arr = new char[N][N];
		for(int i=0;i<related.size();i++) {
			for(int j=0;j<related.get(i).length();j++) {
				arr[i][j] = related.get(i).charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='1' && !v[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		List<String> a1 = new ArrayList<String>();
		a1.add("1100");
		a1.add("1110");
		a1.add("0110");
		a1.add("0001");
		
		List<String> a2 = new ArrayList<String>();
		a2.add("10000");	
		a2.add("01000");	
		a2.add("00100");	
		a2.add("00010");	
		a2.add("00001");	
		
		
		List<String> a3 = new ArrayList<String>();
		a3.add("110");
		a3.add("110");
		a3.add("001");
		
		/*답 6 
		 * 1000001000
0100010001
0010100000
0001000000
0010100000
0100010000
1000001000
0000000100
0000000010
0100000001
		 * 
		 * */
		List<String> a4 = new ArrayList<String>();
		a4.add("1000001000");
		a4.add("0100010001");
		a4.add("0010100000");
		a4.add("0001000000");
		a4.add("0010100000");
		a4.add("0100010000");
		a4.add("1000001000");
		a4.add("0000000100");
		a4.add("0000000010");
		a4.add("0100000001");

		

		System.out.println(countGroups(a1));
		System.out.println(countGroups(a2));
		System.out.println(countGroups(a3));
		System.out.println(countGroups(a4));

	}
	
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
