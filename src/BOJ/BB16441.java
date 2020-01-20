package BOJ;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BB16441 {
	static int N,M;
	static LinkedList<Dot> li;
	static char map[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean v[][];
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == '.' && !v[i][j]) System.out.print('P');
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void bfs() {
		Queue<Dot> q = new LinkedList<Dot>();
		for(int i=0;i<li.size();i++) {
			q.add(li.get(i));
		}
		//System.out.println(q.size());
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(ny < 0 || nx < 0 || nx >= N || ny >= M) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny] == '#') {
					v[nx][ny] = true;
					continue;
				}
				if(map[nx][ny] == '+') { //미끄러짐 
					v[nx][ny] = true;
					int sx = nx;
					int sy = ny;
					while(true) {
						int mx = sx + dr[i][0];
						int my = sy + dr[i][1];
						if(map[mx][my]!='+') {
							nx = mx;
							ny = my;
							break;
						}else {
							sx = mx;
							sy = my;
						}
					}
				}
				v[nx][ny] = true;
				q.add(new Dot(nx,ny));
			}
			//System.out.println(q.size());
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M];
		li = new LinkedList<Dot>();
		String s1 = sc.nextLine();
		for(int i=0;i<N;i++) {
			String s = sc.nextLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'W') li.add(new Dot(i,j));
			}
		}
		bfs();
		print();
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
