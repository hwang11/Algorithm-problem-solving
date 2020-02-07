package Graph;
//유기농배추. dfs
import java.util.*;
public class BOJ1012_dfs {
	static int n;
	static int m;
	static int map[][];
	static int d[][] = {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void dfs(int x,int y) {
		map[x][y] = 0;
		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			if(mx<0 || mx>=n || my<0|| my>=m) continue;
			if(map[mx][my] == 0) continue;
			dfs(mx,my);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int test = 0;test<t;test++) {
			
			n = sc.nextInt();//가로.
			m = sc.nextInt();//세로.
			int count = sc.nextInt();
			map = new int[n][m];
			
			//0으로 map초기화.
			for(int i=0;i<n;i++) {
				Arrays.fill(map[i], 0);
			}
			
			//배추자리 1로 만들기.
			for(int i=0;i<count;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 1) {
						ans ++;
						dfs(i,j);
					} 
				}
			}
			System.out.println(ans);
		}
		
		
	}
}
