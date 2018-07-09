package graph_practice;
import java.util.*;
public class BOJ1987 {
	static int r,c;
	static String s;
	static char a[][];
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void dfs(int x,int y) {
		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			
			if(a[mx][my]==a[x][y]) continue;
			
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		a = new char[r][c];
		for(int i=0;i<r;i++) {
			s = sc.nextLine();
			for(int j=0;j<c;j++) {
				a[i][j] = s.charAt(j);
			}
		}
		dfs(0,0);
		
	}
}
