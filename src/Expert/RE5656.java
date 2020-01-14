package Expert;

import java.util.Scanner;

public class RE5656 {
	static int n,w,h,ans;
	static int map[][];
	static int data[][];
	public static void solve() {
		int B[] = new int[4];
		for(B[0]=0;B[0]<w;B[0]++) 
			for(B[1]=0;B[1]<w;B[1]++) {
				for(B[2]=0;B[2]<w;B[2]++) {
					for(B[3]=0;B[3]<w;B[3]++) {
						copy();
						for(int i=0;i<n;i++) {
							bomb2(B[i]);
							down();
						}
						count();
						if(ans == 0) return;
						if(n<4) break;
					}
					if(n<3) break;
				}
			if(n<2) break;
			}	
	}
	public static void copy(){
		for(int i=0;i<h;i++)
			for(int j=0;j<w;j++)
				map[i][j] = data[i][j];
	}
	public static boolean bomb() {
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j]>10) {
					int d = map[i][j] - 10;
					map[i][j] = 0;
					int sx = (j - d + 1);
					int ex = (j + d -1);
					if(sx<0) sx = 0;
					if(ex>=w) ex = (w-1);
				
					int sy = (i - d + 1);
					int ey = (i + d -1);
					if(sy<0) sy = 0;
					if(ey>=h) ey = (h-1);
					boolean flag = false;
					for(int m=sx;m<=ex;m++) {
						if(map[i][m] == 1)map[i][m] = 0;
						else if(map[i][m]>1 && map[i][m]<10) {
							map[i][m]+=10;
							flag = true;
						}
					}
					for(int k=sy;k<=ey;k++) {
						if(map[k][j] == 1)map[k][j] = 0;
						else if(map[k][j]>1 && map[k][j]<10) {
							map[k][j]+=10;
							flag = true;
						}
					}
					if(flag) return true;
				}
			}
		}
		return false;
	}
	public static void bomb2(int x) { //맨위에 있는 벽돌들..? 
		for(int i=0;i<h;i++)
			if(map[i][x] == 1) {
				map[i][x] = 0;
				return;
			}
			else if(map[i][x] > 1) {
				map[i][x]+=10;
				break;
			}
		
		boolean flag = true;
		while(flag) flag = bomb();
		
	}
	public static void down() {
		for(int j=0;j<w;j++) {
			for(int i=h-1;i>=0;i--) {
				if(map[i][j] == 0) {
					for(int y=i-1;y>=0;y--) {
						if(map[y][j]!=0) {
							map[i][j] = map[y][j];
							map[y][j] = 0;
							break;
						}
					}
				}
			}
		}
		
	}
	public static void count() {
		int cnt = 0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		ans = Math.min(ans, cnt);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			data = new int[h][w];
 			for(int i=0;i<h;i++) {
 				for(int j=0;j<w;j++) {
 					data[i][j] = sc.nextInt();
 				}
 			}
			ans = Integer.MAX_VALUE;
			solve();
			System.out.printf("#%d %d\n",t,ans);
			
		}
	}
}
