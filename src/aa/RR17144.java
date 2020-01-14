package aa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RR17144 {
	static int R,C,T,t,ux,uy,dx,dy;
	static int map[][];
	static int copy[][];
	static int s1[] = {3,0,2,1};
	static int s2[] = {3,1,2,0};
	static int dr[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static void spread() {
		Queue<Dot> q = new LinkedList<Dot>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>4) q.add(new Dot(i,j,map[i][j])); //map[i][j]의 값이 변할 수 있어서 dust에 저장 
			}
		}
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			int cnt = 0;
			int t=0; //for문안에서 선언해 밖에선 계속 0으로 처리됨 
			for(int i=0;i<4;i++) {
				t = dot.dust/5;
				int nx = dot.x + dr[i][0];
				int ny = dot.y + dr[i][1];
				if(nx < 0 || ny < 0 || nx>=R || ny >= C) continue;
				if(map[nx][ny] == -1) continue;
				map[nx][ny]+= t;
				cnt++;
			} 
			map[dot.x][dot.y] -= (t*cnt);
		}
	}
	static void rotate(int x,int y,int a[]) {
		for(int i=0;i<4;i++) {
			while(true) {
				int nx = x + dr[a[i]][0];
				int ny = y + dr[a[i]][1];
				if(nx < 0 || ny < 0 || nx >= R || ny >= C) break; //벽을 만나면 방향을 바꿔 
				if(map[nx][ny]==-1) break;
				copy[nx][ny] = map[x][y];
				x = nx;
				y = ny;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		int ans = 0;
		boolean flag = false;
		map = new int[R][C];
		copy = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					if(!flag) {
						ux = i; uy = j;
						flag = true;
					}else dx = i; dy= j;
				}
			}
		}
		t = 0;
		while(t<T) {
			spread();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					copy[i][j] = map[i][j];
				}
			}
			rotate(ux,uy+1,s1);
			rotate(dx,dy+1,s2);
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[i][j] = copy[i][j];
				}
			}
			map[ux][uy+1] = 0;
			map[dx][dy+1] = 0;
			t++;
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) ans+= map[i][j];
			}
		}
		System.out.println(ans);
	}
	static class Dot{
		int x,y,dust;
		public Dot(int x,int y,int d) {
			this.x =x;
			this.y =y;
			this.dust =d;
		}
	}
}
