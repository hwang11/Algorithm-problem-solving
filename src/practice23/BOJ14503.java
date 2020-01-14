package practice23;
import java.util.*;
public class BOJ14503 {
	static int n;
	static int m;
	static int arr[][] = {{1,0},{-1,0},{0,-1},{0,1}};
	static int map[][];
	static int ans = 0;

	public static void bfs(Dot d) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(d);
		map[d.x][d.y] = 1;
		while(!q.isEmpty()) {
			Dot a = q.poll();
			int count = 0;
			for(int i=0;i<4;i++) {
				int mx = d.x + arr[i][0];
				int my = d.y + arr[i][1];
				int md = d.z + 1; //현재방향.
				if(mx >= n || mx < 0 || my>= m || my < 0) continue;
				if(map[mx][my] == 1) {
					count ++;
					continue;
				}
				if(count == 4) { //후진.
					switch(md) {
					case 1:
						mx--;
						break;
					case 2:
						my--;
						break;
					case 3:
						mx++;
						break;
					case 4:
						my++;
						break;
					}
					if(map[mx][my] == 1) break;
					
				}
				Dot f = new Dot(mx,my,md);
				q.add(f);
			}
			ans++;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Dot e = new Dot(x, y, z);
		bfs(e);
		System.out.println(ans);
	}
	
	public static class Dot{
		int x;
		int y;
		int z;
		public Dot(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
