package Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E2105 {
	static int n,start_x,start_y,ans;
	static boolean v[][];
	static boolean num[];
	static int map[][];
	static int d[][] = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void move(int x,int y,int cnt,int dir) {
		if(dir == 4) {
//			System.out.print("방향 모두돌음.");
			return; 
		}//4방향 다 돌았다면.
		int mx = x+d[dir][0];
        int my = y+d[dir][1];
        if(mx<=0 || my<=0 || mx>n || my>n) {
//        	System.out.print("("+mx+","+my+") 범위 over.");
        	return;
        }
       
      
        if(v[mx][my] || num[map[mx][my]]) {
        	if(start_x==mx&&start_y==my) {
			  if(cnt>ans) ans = cnt;
			  return;
			}
        	else {
        //		System.out.print(map[mx][my]+"중복숫자가 나와서.");
        		return;
        		}
        }
		  v[mx][my] = true;
		  num[map[mx][my]] = true;
	//	  System.out.println("재귀 호출 :"+"("+mx+","+my+")"+" dir: "+dir);
		  move(mx,my,cnt+1,dir);
		  
//		  System.out.println(" return :"+"("+mx+","+my+")"+" dir: "+dir);
//		  System.out.println();
		  move(mx,my,cnt+1,dir+1); // 방향바꾸기.
		  v[mx][my] = false;
		  num[map[mx][my]] = false;

	  }

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			v = new boolean[n+1][n+1];
			num = new boolean[101];
			map = new int[n+1][n+1];
			Arrays.fill(num, false);
			ans = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = false;
				}
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					start_x = i;
					start_y = j;
					v[i][j] = true;
					num[map[i][j]] = true;
//					System.out.println("("+i+","+j+") 시작.");
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
