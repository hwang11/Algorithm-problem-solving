package practice31;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//내가푼것 - 틀림.
public class BOJ2573 {
	static int n,m;
	static int[][] map;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] v;
	
	public static boolean check() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] !=0) return false;
			}
		}
		return true;
	}
	
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				v[i][j] = false;
			}
		}
	}	
	public static boolean devide() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!= 0 && v[i][j] == false) return true; //0이 아닌데 방문아니라면.
			}
		}
		return false;
	}
	
	public static void bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		Dot dot = new Dot(x,y);
		q.add(dot);
		while(!q.isEmpty()) {
			Dot e = q.poll();
			v[e.x][e.y] = true;
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx > n || mx < 0 || my > m || my < 0 || v[mx][my] == true) continue;
				if(map[mx][my] == 0) {
					cnt++; //주변에 0의 개수.
					continue;
				}
				q.add(new Dot(mx,my));
				v[mx][my] = true;
			}
			
			if(cnt > 0) {
				if(map[e.x][e.y] > cnt) {
					map[e.x][e.y] -= cnt;
				}
				else map[e.x][e.y] = 0; //map[e.x][e.y] < cnt
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[301][301];
		v = new boolean[301][301];
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		init();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0) continue;
				bfs(i,j);
				if(devide()) {
					if(check()) System.out.println(0); //모두 0인경우. 
					else System.out.println(ans);
					return;
				}
				ans++;
				init();
			}
		}
		
	}
	
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
