package practice18;
import java.util.*;
import java.io.*;

public static class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
public class BOJ2589 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char map[][] = new char[n][m];
		
		int[] dx = { -1, 0, 1, 0 };
	    int[] dy = { 0, -1, 0, 1 };
	    int ans = 0;

	    for(int i=0;i<n;i++) {
	        map[i] = sc.readLine().toCharArray();
	    }	    
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            Queue<Point> q = new LinkedList<Point>();
	            boolean[][] visited = new boolean[n][m];
	            int[][] dist = new int[n][m];
	            char ch = map[i][j];
	            visited[i][j] = true;
	            q.add(new Point(i, j));
	            int temp = 0;
	 
	            while (!q.isEmpty()) {
	                Point p = q.poll();
	                int x = p.x;
	                int y = p.y;
	 
	                for (int k = 0; k < 4; k++) {
	                    int nx = dx[k] + x;
	                    int ny = dy[k] + y;
	 
	                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
	                        if (!visited[ny][nx] && map[ny][nx] == ch) {
	                            q.add(new Point(ny, nx));
	                            dist[ny][nx] = dist[y][x] + 1;
	                            visited[ny][nx] = true;
	 
	                            if (temp < dist[ny][nx]) {
	                                temp = dist[ny][nx];
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
		
	}
