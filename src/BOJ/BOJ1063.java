package practice31;

import java.util.Scanner;

public class BOJ1063 {
	static int map[][];
	public static boolean range(int x,int y) {
		if(x > 8 || x < 1 || y > 8 || y<1) return false;
		return true;
	}
	public static Dot dr(int x,int y,String st) { //x,y반대로함.
		switch(st) {
		case "R":
			y++;
			break;
		case "L":
			y--;
			break;
		case "B":
			x--;
			break;
		case "T":
			x++;
			break;
		case "RT":
			x++;
			y++;
			break;
		case "LT":
			y--;
			x++;
			break;
		case "RB":
			y++;
			x--;
			break;
		case "LB":
			y--;
			x--;
			break;
		}
		return new Dot(x,y);
	}
	public static void main(String args[]) {
		map = new int[9][9];
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int x1 = (s1.charAt(1) - 48); //숫자.
		int y1 = s1.charAt(0) - 64; //문자.
		int x2 = (s2.charAt(1) - 48);
		int y2 = s2.charAt(0) - 64;
		
		
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String s = sc.next();
			if(!range(dr(x1,y1,s).x,dr(x1,y1,s).y)) continue;
			else {
				x1 = dr(x1,y1,s).x;
				y1 = dr(x1,y1,s).y;
				if(map[x1][y1] == map[x2][y2]) { //돌과 왕의 좌표가 같으면 .
					if(range(dr(x2,y2,s).x,dr(x2,y2,s).y)) {
						x2 = dr(x2,y2,s).x;
						y2 = dr(x2,y2,s).y;
					}
				}
			}
			
		}
		char c = (char)(y1+64);
		System.out.println((char)c+""+x1); //킹.
		
		char c2 = (char)(y2+64);
		System.out.println((char)c2+""+x2); //.

	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
