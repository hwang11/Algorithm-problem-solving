package Graph;
//단지번호붙이
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2667 {
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static int map[][];
	static int n;
	static int ans;
	static int num[];
	public static void dfs(int x,int y) {
		map[x][y] = 0;
		for(int i=0;i<4;i++) {
			int mx = x+d[i][0];
			int my = y+d[i][1];
			if(mx < 0 || mx>= n || my<0 || my>=n) continue;
			if(map[mx][my] == 0) continue;
			num[ans]++;
			dfs(mx,my);
		}
		return;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[26][26];
		num = new int[n*n];
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1) {
					ans++;
					num[ans]++;
					dfs(i,j);
				}
				
			}
		}
		System.out.println(ans);
		Arrays.sort(num);
		for(int i=num.length-ans;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
}
