package Expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E1226 {
	static int map[][];
	static boolean v[][];
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	public static boolean bfs(int x,int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		
		while(!q.isEmpty()) {
			Dot e = q.poll();
			for(int i=0;i<4;i++) {
				int mx = e.x + d[i][0];
				int my = e.y + d[i][1];
				
				if(mx > 15 || mx < 0 || my > 15 || my < 0) continue;
				if(map[mx][my] == 1) continue;
				if(v[mx][my]) continue;
				v[mx][my] = true;
				if(map[mx][my] == 3) return true;
				q.add(new Dot(mx,my));
				
			}
			
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			map = new int[20][20];
			v = new boolean[20][20];
			int n = sc.nextInt();
			for(int i=0;i<16;i++) {
				String s = sc.next();
				for(int j=0;j<16;j++) {
					map[i][j] = s.charAt(j)-48;
					v[i][j] = false;
				}
			}
			for(int i=0;i<16;i++) {
				for(int j=0;j<16;j++) {
					if(map[i][j] == 2) {
						v[i][j] = true;
						if(bfs(i,j)) System.out.println("#"+t+" "+1);
						else System.out.println("#"+t+" "+0);
					}
				}
			}
			
		}
		
	}
	
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
