package aaa;

import java.util.Scanner;

public class E4014 {
	static int N, X,ans;
	static int map[][];

	static void row() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			boolean flag = true;
			boolean down = false;
			int d = map[i][0];
			
			for (int j = 0; j < N-1; j++) { //가로검사 
				if(d != map[i][j+1]) {
					if(d+1 == map[i][j+1]) { //올라가는 경우 
						if(down) {
							flag = false;
							break;
						}
						else {
							if(cnt<X) {
								flag = false;
								break; 
							}
						}
					}else if(d-1==map[i][j+1]){ //내려가는 경우
						if(down) {
							flag = false;
							break;
						}
						down = true; 
					}else { //수가 1이상  차이나는 경우 
						flag = false;
						break;
					}
					cnt = 1;
					d = map[i][j+1];
				}else { //연속했다면 
					cnt++;
					if(down) {
						if(cnt>=X) {
							down = false;
							cnt = 0;
						}
					}
				}
				
			}
			if(down && cnt < X) flag = false;
			if(flag) {
				ans++;
			}
			
		}
	}
	static void col() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			boolean flag = true;
			boolean down = false;
			int d = map[0][i];
			for (int j = 0; j < N-1; j++) { //가로검사 
				if(d != map[j+1][i]) {
					if(d+1 == map[j+1][i]) { //올라가는 경우 
						if(down) {
							flag = false;
							break;
						}
						else {
							if(cnt<X) {
								flag = false;
								break; 
							}
						}
					}else if(d-1==map[j+1][i]){ //내려가는 경우
						if(down) {
							flag = false;
							break;
						}
						down = true; 
					}else { //수가 1이상  차이나는 경우 
						flag = false;
						break;
					}
					cnt = 1;
					d = map[j+1][i];
				}else { //연속했다면 
					
					cnt++;
					if(down) {
						if(cnt>=X) {
							down = false;
							cnt = 0;
						}
					}
				}
				
			}
			if(down && cnt < X) flag = false;
			if(flag) {
				ans++;
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			row();
			col();
			System.out.println("#"+t+" "+ans);
		}
	}
}
