package BOJ;

import java.util.Scanner;

public class BOJ14499 {
	static int temp[] = new int[7];
	static int d[] = new int[7];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int map[][];
	static int x;
	static int y;
	static int mx;
	static int my;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	
	public static void c(int v) {
		int[] temp = d.clone();
		if(v==1) {
			d[3] = temp[1];
			d[1] = temp[4];
			d[6] = temp[3];
			d[4] = temp[6];
			d[2] = temp[2];
			d[5] = temp[5];
		}
		else if(v==2) {
			d[4] = temp[1];
			d[1] = temp[3];
			d[3] = temp[6];
			d[6] = temp[4];
			d[2] = temp[2];
			d[5] = temp[5];
		}
		else if(v==3) {
			d[2] = temp[1];
			d[1] = temp[5];
			d[5] = temp[6];
			d[6] = temp[2];
			d[3] = temp[3];
			d[4] = temp[4];
		}
		else{
			d[5] = temp[1];
			d[1] = temp[2];
			d[6] = temp[5];
			d[2] = temp[6];
			d[3] = temp[3];
			d[4] = temp[4];
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		
		x = sc.nextInt();
		y = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<k;i++) {
			int v = sc.nextInt();
			int mx = dx[v-1] + x;
			int my = dy[v-1] + y;
			if(0 <= mx && mx < m && 0 <= my && my < n) {
				c(v);
				if(map[my][mx] == 0) map[my][mx] = d[6];
				else {
					d[6] = map[my][mx];
					map[my][mx] = 0;
				}
				x = mx;
				y = my;
				sb.append(d[1] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
