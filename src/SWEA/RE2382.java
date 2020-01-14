package Expert;

import java.util.Scanner;
//겹치는 부분이 발생하므로 임시맵을 두어 새로 계속 갱신.
//3차원 배열로 하다가 런타임에러남.
public class RE2382 {
	static int n,m,k;
	static Dot map[][];
	static Dot nmap[][];
	static int dis[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	public static void move() {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(map[j][k].num == 0) continue;
					int md = map[j][k].d;
					int mx = j+dis[md][0];
					int my = k+dis[md][1];
					if(mx < 0 || mx > n || my < 0 || mx > n) continue;
					
					if(mx == 0 || mx == (n-1) || my == (n-1) || my == 0) {
						nmap[mx][my].num = (map[j][k].num)/2;
						nmap[mx][my].max = (map[j][k].num)/2;
						if(md == 1) nmap[mx][my].d = 2;
						else if(md == 2) nmap[mx][my].d = 1;
						else if(md == 3) nmap[mx][my].d = 4;
						else nmap[mx][my].d = 3;
					}
					else {
						if(nmap[mx][my].d > 0) {
							nmap[mx][my].num += map[j][k].num;
							if(nmap[mx][my].max < map[j][k].num) {
								nmap[mx][my].max = map[j][k].num;
								nmap[mx][my].d = md;
							}
						}
						else {
							nmap[mx][my].d = map[j][k].d;
							nmap[mx][my].num = map[j][k].num;
							nmap[mx][my].max = map[j][k].num;
						}
					}
					
				}
			}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = nmap[i][j];
				nmap[i][j] = new Dot(0,0,0);
			}
		}
		}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			map = new Dot[n][n];
			nmap = new Dot[n][n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					map[j][k] = new Dot(0,0,0);
					nmap[j][k] = new Dot(0,0,0);
				}
			}
	
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int num = sc.nextInt();
				int d = sc.nextInt();
				map[x][y] = new Dot(num,d,num);
			}
			for(int i=0;i<m;i++) {
				move();
			}
			int sum =0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j].num == 0) continue;
					sum += map[i][j].num;
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	public static class Dot{
		int num;
		int d;
		int max;
		public Dot(int num,int d,int max) {
			this.num = num;
			this.d = d;
			this.max = max;
		}
	}
}
