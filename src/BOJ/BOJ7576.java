package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//틀림 ㅠ
public class BOJ7576 {
	static int map[][];
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n;
	static int m;
	static int ans;
	static boolean check;
	static Queue<Dot> q = new LinkedList<Dot>();

	
	//최대값이 총 걸리는 일 수를 의미.
	private static int getMax() {
		ans = -1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0) { //토마토가 모두 익지 못하는 상황.
					return -1;
				} 
				else if(map[i][j] > ans) {
					ans = map[i][j];
				}
			}
		}
		
		return ans-1;
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				if(mx > n || mx < 0 || my > m || my < 0) continue;
				if(map[mx][my] > map[e.x][e.y] +1 || map[mx][my] == 0) {
					map[mx][my] = map[e.x][e.y] + 1;
					q.add(new Dot(mx,my));
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();//6
		n = sc.nextInt();//4
		map = new int [n+1][m+1];
		check = true;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1)
                    q.add(new Dot(i,j));
                else
                    check=false;
			}
		}
		if(check) {
			System.out.println(0);
			return;
		}
		bfs();
		System.out.println(getMax());

		
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
