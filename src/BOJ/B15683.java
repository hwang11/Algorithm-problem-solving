package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class B15683 {
	static int N,M,cnt,ans;
	static int arr[][];
	static int tmp[][];
	static LinkedList<Dot> li;
	static int dr[][] = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};  // 우 좌 상 하 
	static void go(int x,int y,int d) {
		int nx = x;int ny = y;
		while(true) {
			nx += dr[d][0];
			ny += dr[d][1];
			if(nx >= N || ny >= M || nx < 0 || ny < 0) break;
			if(tmp[nx][ny]==6) break;
			tmp[nx][ny] = 7;
		}
	}
	static void fill(int idx) {
		int num = li.get(idx).c;
		int dn = li.get(idx).r;		
		int x = li.get(idx).x;
		int y = li.get(idx).y;
		if(num == 1) {
			go(x,y,dn+1);
		}
		else if(num == 2) {
			if(dn%2==0) {
				go(x,y,1);
				go(x,y,2);
			}
			else{
				go(x,y,3);
				go(x,y,4);
			}
		}
		else if(num == 3) {
			if(dn==0) {
				go(x,y,3); //상 
				go(x,y,1); //우 
			}else if(dn==1) {
				//우 하 
				go(x,y,1);
				go(x,y,4);
			}else if(dn==2) {
				//좌하 
				go(x,y,2);
				go(x,y,4);
			}else {
				//좌상 
				go(x,y,2);
				go(x,y,3);
			}
		}
		else if(num == 4){
			if(dn==0) {
				//우상좌 
				go(x,y,1);
				go(x,y,2);
				go(x,y,3);
			}
			else if(dn==1) {
				//상하우 
				go(x,y,3);
				go(x,y,4);
				go(x,y,1);
			}
			else if(dn==2) {
				//우좌하 
				go(x,y,1);
				go(x,y,2);
				go(x,y,4);
			}
			else {
				//상하좌 
				go(x,y,3);
				go(x,y,4);
				go(x,y,2);
			}
		}
		else {
			go(x,y,1);
			go(x,y,2);
			go(x,y,3);
			go(x,y,4);
		}
	}
	static void init() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j] = arr[i][j];
			}
		}
	}
	static void dfs(int dep) {
		if(dep == li.size()) {
			init();
			for(int i=0;i<li.size();i++) {
				fill(i);
			}
			ans = Math.min(count(), ans);
			return;
		}
		for(int i=0;i<4;i++) {
			li.get(dep).r = i;
			dfs(dep+1);
		}
		
	}
	static int count() {
		cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		tmp = new int[N][M];
		li = new LinkedList<Dot>();
		ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > 0 && arr[i][j] < 6) li.add(new Dot(arr[i][j],i,j));
			}
		}
		dfs(0);
		System.out.println(ans);
	}
	static class Dot{
		int c,x,y,r;
		public Dot(int c,int x,int y) {
			this.c = c;
			this.x = x;
			this.y = y;
		}
	}
}
