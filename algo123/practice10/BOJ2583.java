package practice10;
import java.util.*;
public class BOJ2583 {
	Scanner sc = new Scanner(System.in);
	int M = sc.nextInt();
	int N = sc.nextInt();
	int k = sc.nextInt();
	
	boolean visit[][] = new boolean[101][101];
	int dx[] = { -1,1,0,0 };
	int dy[] = { 0,0,-1,1 };
	
	boolean isranged(int x,int y) {
		if (x < 0 || x >= N|| y < 0 || y >= M) return false;
		return true;
	}

	public int dfs(int x,int y) {
		visit[x][y] = true;
		int ret = 1;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		    if (!isranged(nx, ny) || visit[nx][ny] || board[nx][ny] == '0') continue;
		    ret += dfs(nx, ny);

		}
		
		return ret;
	}
	
	
	public static void main(String args[]) {

		int arr[][] = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = 0;
			}
		}
		while(true) {
			if(k==0) break;
			int a,b,c,d;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			for(int i=b;i<d;i++) {
				for(int j=a;j<c;j++) {
					arr[i][j]=1;
				}
			}
			k--;
		}
		
		
	}
}
