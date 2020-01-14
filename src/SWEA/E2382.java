package Expert;

import java.util.Scanner;

public class E2382 {
	static int n,m,k;
	static Dot map[][];
	
	public static boolean range(int x,int y) {
		if(x > n || x < 0 || y > n || y < 0 ) {
			return false;
		}
		return true;
	}
	
	public static void change(int mx,int my,int x,int y) {
		if(map[mx][my].num > 0) {
			if(map[mx][my].num < map[x][y].num) {
				map[mx][my].d = map[x][y].d;
				map[mx][my].num += map[x][y].num;
			} 
			else {
				map[mx][my].num += map[x][y].num;
			}
		}
		else if(mx == 0 || my == 0 || mx == n-1 || my == n-1){
			map[mx][my].num = (map[x][y].num)/2;
			//System.out.println("map["+mx+"]["+my+"].num"+map[mx][my].num);
			if(map[x][y].d == 1) map[mx][my].d = 2;
			else if(map[x][y].d == 2) map[mx][my].d = 1;
			else if(map[x][y].d == 3) map[mx][my].d = 4;
			else map[mx][my].d = 3;
		}
		else { //비어있던 자리로 가게되면.
			map[mx][my].num += map[x][y].num;
		}
		//옮기고나면.
		map[x][y].num = 0;
		map[x][y].d = 0;
	}
	
	public static void move() {
		System.out.println("t:");
		while(m>0) {
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					if(map[x][y].d > 0) {
						switch (map[x][y].d) {
						case 1:
							int mx = x;
							int my = y-1;
							if(range(mx,my)) {
								change(mx,my,x,y);
							}
							break;
						case 2:
							int mx2 = x;
							int my2 = y++;
							if(range(mx2,my2)) {
								change(mx2,my2,x,y);
							}
							break;
						case 3:
							int mx3 = x--;
							int my3 = y;
							if(range(mx3,my3)) {
								change(mx3,my3,x,y);
							}
							break;
						case 4:
							int mx4 = x++;
							int my4 = y;
							if(range(mx4,my4)) {
								change(mx4,my4,x,y);
							}
							break;

						default:
							break;
						}
					}
				}
			}
			m--;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t=1;t<=10;t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			map = new Dot[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = new Dot(0);
					map[i][j].d = 0;
				}
			}
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int num = sc.nextInt();
				int d = sc.nextInt();
				map[x][y].num = num;
				map[x][y].d = d;
			}
			
			move();
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j].num >0) {
						ans += map[i][j].num;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	public static class Dot{
		int num;
		int d;
		public Dot(int num) {
			this.num = num;
		}
	}
}
