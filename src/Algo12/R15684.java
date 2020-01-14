package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class R15684 {
	static int N,M,H,ans;
	static int ret;
	static int map[][];
	
	public static boolean chk() {
		int pos;
		for(int i=1;i<=N;i++) {
			pos = i;
			for(int j=1;j<=H;j++) {
				if(map[j][pos] == 1) { //오른쪽으로 이동하는 길 
					pos++;
				} 
				else if(map[j][pos-1] == 1) {//왼쪽으로 이동하는 길 
					pos--; //pos가 위에서 1 증가했다면 -1해야 원래걸 보는 것이므로 
				}
			}
			if(pos != i) return false;
		}
		return true;
	}
	static void go(int cnt,int x,int y) {
		if(cnt>=ans) return;
		if(chk()) {
			ans = cnt;
			return;
		}
		if(cnt == 3) return;
		for(int i=y;i<=H;i++,x=1) {//i가 증가하면 다시 1부터 j를 봐야하므
			for(int j=x;j<N;j++) {
				if(map[i][j] == 1) {
					j++;
					continue;
				}
				map[i][j] = 1;
				go(cnt+1,j+2,i);
				map[i][j] = 0;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H+1][N+1];
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
		}
		ans = Integer.MAX_VALUE;
		go(0,1,1);
		if(ans > 3) ans = -1;
		System.out.println(ans);
		
	}
}
