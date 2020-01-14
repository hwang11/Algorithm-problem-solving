package graph_practice;
import java.util.*;
//미로탐색.
public class BOJ2178 {
	static int n,m;
	static int map[][];
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int count = 0;
	static boolean visited[][];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		String nString = "";
		int cnt = 0;
        for (int i = 0; i < n; i++) {
            nString = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(nString.charAt(j) + "");
                visited[i][j] = false;
            }
        }
        
        visited[0][0] = true;
        
        Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(0,0,0));
		
		while(!q.isEmpty()) {
			Dot v = q.poll();
			cnt++;
			if(v.x == n-1 && v.y == m-1) break;
			
			for(int i=0;i<4;i++) {
				int mx = v.x + d[i][0];
				int my = v.y + d[i][1];
				
				if(mx<0 || mx >= n || my<0 || my>=m) continue;
				if(map[mx][my] == 0 || visited[mx][my]) continue;
				
				q.add(new Dot(mx,my,cnt));
				visited[mx][my] = true;
			}
			
		}
		System.out.println(cnt);
		
	}

}

class Dot {
	int x;
	int y;
	int cnt;
	Dot(int x,int y,int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
