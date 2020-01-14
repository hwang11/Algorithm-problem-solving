package Expert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E5656 {
	static int map[][][];
	static int n,w,h,ans,max;
	static int d[][] = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void cpy(int dep){
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				map[dep][i][j] = map[dep-1][i][j];
			}
		}
	}
	public static void drop(int dep){
		
		for(int j=0;j<w;j++) {
			Queue q = new LinkedList<Integer>();
			for(int i=h-1;i>=0;i--) {
				if(map[dep][i][j]>0){
					q.add(map[dep][i][j]);
					map[dep][i][j] = 0; //원래 있던 자리는 0으로.
				}
			}
			//System.out.print("q: "+q.size()+" h-1: "+(h-1)+" ");
			if(h-1 < q.size()) System.out.println("d이런경우 ");
			for(int i=h-1;i>(h-1-q.size());i--) {
				map[dep][i][j] = (int) q.poll();
			}
			
		}
	}
	public static int dfs(int x,int y,int dep) {
		int r = map[dep][x][y];
		int v = 1;
		map[dep][x][y] = 0; //터트리기 
		for(int i=0;i<r;i++) {
			for(int j=0;j<4;j++) {
				int mx = x +i*d[j][0];
				int my = y +i*d[j][1];
				if(mx < 0 || my < 0 || mx >= h || my >= w || map[dep][mx][my] == 0) continue;
				v+=dfs(mx,my,dep);
			}
		}
		return v;
	}
	public static int run(int dep) {
		if(dep>n) {
			return 0;
		}
		int ans = 0;
		for(int j=0;j<w;j++) {
			cpy(dep);
			int tmp = 0;
			boolean flag = true;
			for(int i=0;i<h;i++) {
				if(map[dep][i][j] > 0) {
					flag = false;
					tmp = dfs(i,j,dep);
					break;
				}
			}
			
			if(flag) continue;
			drop(dep);
			ans = Math.max(ans, (run(dep+1)+tmp));
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				System.out.print(map[dep][i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		return ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			ans = 0;
			int sum = 0;
			map = new int[5][h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[0][i][j] = sc.nextInt();
					if(map[0][i][j]>0) sum++;
				}
			}
			int result = 0;
			System.out.println("sum: "+sum);
			
			result = sum - run(1);
			System.out.println("run:" +run(1));
			System.out.println("#"+t+" "+result);
			
		}
	}
	static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
