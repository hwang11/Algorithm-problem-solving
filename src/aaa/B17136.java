package aaa;

import java.util.Scanner;

public class B17136 {
	static int ans, cnt,min;
	static int map[][];
	static int v[][];
	static int p[] = { 0, 5, 5, 5, 5, 5 };
	public static void dfs(int total,int dep,int r) {
		if(dep >= min) return;
		if(total == cnt) {
			min = Math.min(min, dep);
			return; //다 색종이로 덮었으면 return
		}
		for (int i = r; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(v[i][j]==1) continue;
				if(map[i][j] == 1) {
					boolean flag = false;
					for (int k = 5; k > 0; k--) {
						if(p[k] == 0) continue;
						if(i+k > 10 || j+k >10) continue;
						if(!flag) {
							flag = chk(i,j,k);
						}
						if(flag) {
							p[k]--;
							visit(i,j,k);
							dfs(total+(k*k),dep+1,i);
							p[k]++;
							visit(i,j,k);
						}
					}
					//if(!flag) return;
				}
				if(map[i][j] == 1) return;
			}
		}
	}

	public static boolean chk(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void visit(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (v[i][j] == 0) v[i][j] = 1;
				else v[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		v = new int[10][10];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					cnt++;
			}
		}
		dfs(0,0,0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
