package Algo10;

import java.util.Scanner;
//2차원 배열에서 1차원 배열로 바꿨더니 성공 
public class t5 {
	static int n,m,x,y,k;
	static int die[];
	static int dr[][] = {{0,1},{0,-1},{-1,0},{1,0}}; //동서북남 
	static int map[][];
	// 1 2 3 4 5 6 
	
	//동 1->4 / 3->1 / 6->3 / 4-> 6 
	//서 4->1 / 6->4 / 3-6 / 1-3
	//북 6-2 / 1-5/ 2-1 / 5-6
	//남 1-2 / 5-1 / 6-5 / 2-6 
	
	public static void solve(int v) {
		int nx = x + dr[v-1][0];
		int ny = y + dr[v-1][1];
		if(nx < 0 || ny < 0 || nx >= n || ny >= m) return; //범위 밖이면 명령 수행 X 
		int[] temp = die.clone();
		if(v==1) {
			die[3] = temp[1];
			die[1] = temp[4];
			die[6] = temp[3];
			die[4] = temp[6];
			die[2] = temp[2];
			die[5] = temp[5];
		}
		else if(v==2) {
			die[4] = temp[1];
			die[1] = temp[3];
			die[3] = temp[6];
			die[6] = temp[4];
			die[2] = temp[2];
			die[5] = temp[5];
		}
		else if(v==3) {
			die[2] = temp[1];
			die[1] = temp[5];
			die[5] = temp[6];
			die[6] = temp[2];
			die[3] = temp[3];
			die[4] = temp[4];
		}
		else{
			die[5] = temp[1];
			die[1] = temp[2];
			die[6] = temp[5];
			die[2] = temp[6];
			die[3] = temp[3];
			die[4] = temp[4];
		}
		x = nx;
		y = ny;
		if(map[nx][ny] != 0) {
			die[1] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny]=die[1];
		}
		for(int i=1;i<=6;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		for(int i=1;i<=6;i++) {
			System.out.print(die[i]+" ");
		}
		System.out.println(); 
//		System.out.printf("%d,%d\n",nx,ny);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(die[6]); //맨 윗면 
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		die = new int[7];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			int d = sc.nextInt();
			solve(d);
		}
		
	}
}
