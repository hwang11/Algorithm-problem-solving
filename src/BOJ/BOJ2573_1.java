package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2573_1 {
//	static int n,m;
//	static int[][] map;
//	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
//	static boolean[][] v;
//
//	public static int devide() {
//		int number = 0;
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				if(map[i][j]> 0 && !v[i][j]) {
//					++number;
//					dfs(i,j);
//				} 
//			}
//		}
//		return number;
//	}
//	
//	public static int newyear(int x,int y) {
//		int cnt = 0;
//		for(int i=0;i<4;i++) {
//			int mx = x + d[i][0];
//			int my = y + d[i][1];
//			if(mx > n || mx < 0 || my > m || my < 0) continue;
//			if(map[mx][my] == 0 && map[x][y] > 0) ++cnt;
//		}
//		
//		return cnt;
//	}
//	public static void dfs(int x,int y) {
//		v[x][y] = true;
//		for(int i=0;i<4;i++) {
//			int mx = x + d[i][0];
//			int my = y + d[i][1];
//			if(mx > n || mx < 0 || my > m || my < 0 || v[mx][my] == true) continue;
//			if(map[mx][my] <= 0) continue;
//			v[mx][my] = true;
//			dfs(mx,my);
//		}
//	}
//	
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		map = new int[301][301];
//		v = new boolean[301][301];
//		int ans = 0;
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//		int tmp = 0;
//		while((tmp = devide()) < 2) {
//			if(tmp == 0) { //다 녹았는데도 분리안된경우.
//				ans = 0;
//				break;
//			}
//			++ans;
//			v = new boolean[301][301];
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					if(map[i][j] > 0) map[i][j] -= newyear(i,j);
//				}
//			}
//		}
//		System.out.println(ans);
//		
//		
//	}
//	
//	public static class Dot{
//		int x;
//		int y;
//		public Dot(int x,int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
	static int[][] map = new int[301][301];
	static int[][] temp = new int[301][301];
	static boolean[][] visited = new boolean[301][301];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int n, m;
	 
	public static void main(){
		Scanner sc = new Scanner(System.in);
		
	    n = sc.nextInt();
	    m = sc.nextInt();
	    int ans = 0;
	 
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            map[i][j] = sc.nextInt();
	        }
	    }
	 
	    int tmp = 0;
	    while ((tmp = componentNumber()) < 2) {
	        if (tmp == 0) {
	            ans = 0;
	            break;
	        }
	        ++ans;
	        visited = new boolean[301][301];
	 
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (map[i][j] > 0) {
	                    temp[i][j] = nextYear(i, j);
	                }
	            }
	        }
	 
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                map[i][j] -= temp[i][j];
	            }
	        }
	    }
	    System.out.println(ans);
	}
	 
	public static int componentNumber() {
	    int component = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (!visited[i][j] && map[i][j] > 0) {
	                ++component;
	                dfs(i, j);
	            }
	        }
	    }
	    return component;
	}
	 
	public static void dfs(int y, int x) {
	    visited[y][x] = true;
	 
	    for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + x;
	        int ny = dy[i] + y;
	 
	        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
	            if (!visited[ny][nx] && map[ny][nx] > 0) {
	                dfs(ny, nx);
	            }
	        }
	    }
	}
	 
	public static int nextYear(int y, int x) {
	    int cnt = 0;
	    for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + x;
	        int ny = dy[i] + y;
	 
	        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
	            if (map[ny][nx] <= 0 && map[y][x] > 0) {
	                ++cnt;
	            }
	        }
	    }
	    return cnt;
	}
}