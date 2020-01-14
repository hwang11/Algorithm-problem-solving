package practice26;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ2210 {
	static HashSet<String> hs = new HashSet<String>();
	static String a[][];
	static int d[][] = {{0,1},{0,-1},{1,0},{-1,0}}; 
	public static void digit(String num,int x,int y,int cnt) {
		if(cnt == 6) {
			hs.add(num);
			return;
		}
		for(int i=0;i<4;i++) {
			int mx = x + d[i][0];
			int my = y + d[i][1];
			if(mx>=5 || mx <0 || my < 0 || my >= 5) continue;
			digit(a[mx][my]+num,mx,my,cnt+1);
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = new String[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				a[i][j] = Integer.toString(sc.nextInt());
			}
		}
		String s = new String();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				digit(s,i,j,0);
			}
		}
		System.out.println(hs.size());
	}
}
