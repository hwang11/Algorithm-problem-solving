package practice30;

import java.util.Scanner;

public class BOJ2580_1 {
	static int map[][];
	static int currentRow;
	static int currentCol;
	
	public static boolean done() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				if(map[i][j] == 0) {
					currentRow = i;
					currentCol = j;
					return false;
				} 
				
			}
		}
		return true;
	}
	public static boolean fill() {
		int r,c; 
		if(done()) {
			return true;
		}
		r = currentRow;
		c = currentCol;
		
		for(int n=1;n<=9;n++) {
			if(checkRow(r,n) && checkCol(c,n) && checkBox(c,r,n)) {
				map[r][c] = n;
				if(fill()) {
					return true;
				}
				map[r][c] = 0;
			}
		}
		return false;
	}
	
	public static boolean checkRow(int r,int n) {
		for(int i=1;i<=9;i++) {
			if(map[r][i] == n) return false;
		}
		return true;
	}
	public static boolean checkCol(int c,int n) {
		for(int i=1;i<=9;i++) {
			if(map[i][c] == n) return false;
		}
		return true;
	}
	public static boolean checkBox(int c, int r,int n) {
		int row = ((int)Math.ceil(r/3.0) -1 ) * 3 + 1;
		int col = ((int)Math.ceil(c/3.0) -1 ) * 3 + 1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[row+i][col+j] == n) return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		fill();
		System.out.println();
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
