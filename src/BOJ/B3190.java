package Algo10;

import java.util.LinkedList;
import java.util.Scanner;

public class B3190 {
	static int n,k,l,ans,t,d,x,y;
	static int map[][];
	static LinkedList<Time> time = new LinkedList<Time>();
	static LinkedList<Dot> bam = new LinkedList<Dot>();
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}}; //우 하 좌 상  
	static void solve() {
		while(true) {
			if(!time.isEmpty()) {
				if(t == time.get(0).x) { //방향바꾸기 
					if(time.get(0).c.equals("D")) { d++; d%=4;}
					else {
						d--; 
						if(d<0) d += 4;
						d%=4;
					}
					time.removeFirst(); 
				}
			}
			int nx = x + dr[d][0];
			int ny = y + dr[d][1];
			if(nx <= 0 || ny <= 0 || nx > n || ny > n) return; //종료 
			for(int i=0;i<bam.size();i++) { //몸이랑 부딪히면 
				if(nx == bam.get(i).x && ny == bam.get(i).y) return; //종료 
			}
			bam.addFirst(new Dot(nx,ny)); //머리 증가.
			if(map[nx][ny] == 3) {
				map[nx][ny] = 0; //사과 없애기 
			}
			else {//꼬리 원위치 
				bam.removeLast();
			}
			t++;
			x = nx;
			y = ny;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		k = sc.nextInt();
		for(int i=0;i<k;i++) {//사과 위치 
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 3;
		}
		l = sc.nextInt();
		for(int i=0;i<l;i++) {
			int x = sc.nextInt();
			String c = sc.next();
			time.add(new Time(x,c));
		}
		
		bam.add(new Dot(1,1));
		t = 0;
		x = 1;
		y = 1;
		solve();
		t++;
		System.out.println(t);
	}
	public static class Time{
		int x;
		String c;
		public Time(int x,String c) {
			this.x = x;
			this.c = c;
		}
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
