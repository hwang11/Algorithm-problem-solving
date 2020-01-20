package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class R11559 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static ArrayList<Point> list;
	 
	public static void paint() {
	    for (int i = 0; i < 6; i++) {
	        for (int j = 10; j >= 0; j--) {
	            for (int k = 11; k > j; k--) {
	                if (map[j][i] != '.' && map[k][i] == '.') {
	                    map[k][i] = map[j][i];
	                    map[j][i] = '.';
	                    break;
	                }
	            }
	        }
	    }
	}
	 
	public static void dfs(int y, int x, char ch) {
	    for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + x;
	        int ny = dy[i] + y;
	 
	        if (0 <= nx && nx < 6 && 0 <= ny && ny < 12) {
	            if (!visited[ny][nx] && map[ny][nx] == ch) {
	                list.add(new Point(ny, nx));
	                visited[ny][nx] = true;
	                dfs(ny, nx, ch);
	            }
	        }
	    }
	}
	 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int ans = 0;
		 
//	    for (int i = 0; i < 12; i++) {
//	        map[i] = sc.readLine().toCharArray();
//	    }
	 
	    // 1. 모든 곳을 돌면서 터트릴 수 있는 뿌요 찾기(크기 4이상).
	    // 2. 터트릴 수 있는 뿌요 있다면 모두 터트리기.
	    // 3. 터트린 곳 메꾸기 위해 맵 다시 그리기
	 
	    while (true) {
	        boolean flag = false;
	        visited = new boolean[12][6];
	 
	        // 터트릴 수 있는 뿌요가 여러 그룹으로 나누어 있을 수 있기 때문에 하나의 정점을 기준으로 모두 탐색.
	        for (int i = 0; i < 12; i++) {
	            for (int j = 0; j < 6; j++) {
	                if (!visited[i][j] && map[i][j] != '.') {
	                    list = new ArrayList<Point>();
	                    dfs(i, j, map[i][j]);
	                    if (list.size() >= 4) {
	                        flag = true;
	                        for (Point p : list) {
	                        	System.out.printf("%d,%d\n",p.y,p.x);
	                            map[p.y][p.x] = '.';
	                        }
	                        System.out.println();
	                    }
	                }
	            }
	        }
	 
	        if (!flag) {
	            break;
	        } else {
	            ans++;
	        }
	 
	        paint();
	    }
	    System.out.println(ans);
	}
	public static class Point {
	    int y, x;
	 
	    Point(int y, int x) {
	        this.y = y;
	        this.x = x;
	    }
	}


}