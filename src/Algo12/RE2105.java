package Algo12;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RE2105 {
	static int n,start_x,start_y,ans;
	static boolean v[][];
	static boolean num[];
	static int map[][];
	static int d[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void move(int x,int y,int cnt,int dir) {
		if(dir == 4) return; //4방향 다 돌았다면.
		int mx = x+d[dir][0];
        int my = y+d[dir][1];
        if(mx<0 || my<0 || mx>=n || my>=n) return;
      
        if(v[mx][my] || num[map[mx][my]]) {
        	if(start_x==mx&&start_y==my) {
			  if(cnt>ans) ans = cnt;
			  return;
			}
        	else return;
        }
		  v[mx][my] = true;
		  num[map[mx][my]] = true;
		  move(mx,my,cnt+1,dir);
		  move(mx,my,cnt+1,dir+1); // 방향바꾸기.
		  v[mx][my] = false;
		  num[map[mx][my]] = false;

	  }

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			v = new boolean[n][n];
			num = new boolean[101];
			map = new int[n][n];
			Arrays.fill(num, false);
			ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = false;
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					start_x = i;
					start_y = j;
					v[i][j] = true;
					num[map[i][j]] = true;
					move(i,j,1,0);
					v[i][j] = false;
					num[map[i][j]] = false;
				}
			}
			if(ans < 4) ans = -1; //ㄱ사각형이므로 최소 4개는 나와줘야함.
			System.out.println("#"+t+" "+ans);
		}
	}

}
