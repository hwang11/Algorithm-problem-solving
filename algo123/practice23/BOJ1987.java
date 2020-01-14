package practice23;
import java.util.*;
//알파
public class BOJ1987 {
	static int r,c;
	static String s;
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean visited[] = new boolean[26];
	static int count = 1;
	static int ans = 1;
	static char[][] map;
	
 	public static void dfs(int x,int y) {
 		visited[(int)map[x][y]] = true;
		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			if(mx >= r || mx < 0 || my >= c || my < 0) continue;
			if(visited[(int)map[mx][my]]) continue;
			ans = Math.max(++count, ans);
			dfs(mx,my);
		}
		--count;
		visited[(int)map[x][y]] = false;
	}
 	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		String ss = sc.nextLine();
	    map = new char[r][c];
	 
	    for (int i = 0; i < r; i++) {
	    	s = sc.nextLine();
	        for (int j = 0; j < c; j++) {
	            map[i][j] = (char) (s.charAt(j) - 'A');
	        }
	    }

		Arrays.fill(visited, false);
		visited[map[0][0]] = true;
		dfs(0,0);
		System.out.println(ans);
	}
}
