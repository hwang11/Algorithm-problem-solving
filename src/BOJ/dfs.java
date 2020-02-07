package BOJ;//DFS 경로찍기 
import java.util.Scanner;

public class dfs {
	static int map[][];
	static boolean v[][];
	static int d[][] = {{0,1},{1,0},{0,-1},{-1,0
		}};
	static void print() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int cnt,int x,int y) {
		print();
		System.out.println();
		if(cnt == 4) {
			return;
			
		}
		for(int i=0;i<4;i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(nx < 0 || ny < 0 || nx>=4 || ny >=4) continue;
			if(v[nx][ny]) continue;
			v[nx][ny] = true;
			map[nx][ny] = 1;
			dfs(cnt+1,nx,ny);	
			v[nx][ny] = false;
			map[nx][ny] = 0;
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new int[4][4];
		v = new boolean[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,0);
	}
}
