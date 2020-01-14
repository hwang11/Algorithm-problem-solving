package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class E2105 {
	static int n,ans;
	static Dot start;
	static boolean v[][];
	static boolean c[];
	static int map[][];
	static int dr[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static LinkedList<Integer> li;
//	static int rot(int d) {
//		int nd = ++d;
//		return nd;
//	}
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(v[i][j]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
	}
	static boolean chk() {
		for(int i=0;i<4;i++) {
			if(!c[i]) return false;
		}
		return true;
	}
	public static void solve(int y,int x,int goal) {
		int cnt = 0;
		int d = 0;
		int cnt2 = 0;
		while(true) {
			v[y][x] = true;
			//System.out.printf("%d %d\n",y,x);
			if(chk()) {
				///if(!chk()) return;
				System.out.printf("start %d %d\n",start.y,start.x);

				for(int i=0;i<4;i++) {
					if(c[i]) System.out.print("1");
					else System.out.print
					("0");
				}
				System.out.println();
				System.out.println("li size:"+li.size());
				print();
				ans = Math.max(ans, li.size());
				return; //벽에 3번 닿으면? 
			}
			//System.out.println("d"+d);
			int ny = y + dr[d][0];
			int nx = x + dr[d][1];
			if(ny < 0 || nx < 0 || ny >=n || nx >=n || cnt2 == goal) {
				//if(cnt2 == goal) System.out.println("goal ");
				cnt++;
				cnt2 = 0;
				
				d++;
				continue;
			}
			if(v[ny][nx]) return;
			if(li.contains(map[ny][nx])) {
				//System.out.println("겹침 ");
				return;
			}
			c[d] = true;
			//System.out.printf("%d %d d:%d\n",ny,nx,d);
			//v[ny][nx] = true;
			li.add(map[ny][nx]);
			y = ny;
			x = nx;
			cnt2++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			ans = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int k=1;k<=n-2;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						v = new boolean[n][n];
						c = new boolean[4];
						li = new LinkedList<Integer>();
						start = new Dot(i,j);
						li.add(map[i][j]);
						c[0] = true;
						//System.out.printf("시작 %d,%d===================\n",i,j);
						solve(i,j,k);
					}
				}
			}
			if(ans == 0) ans = -1;
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static public class Dot{
		int y;
		int x;
		public Dot(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
