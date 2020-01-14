package Algo10;

import java.util.Scanner;

public class B14891 {
	static char a[][];
	static boolean v[];
	static int k,ans;
	static void rotate(int num,int d) {
		System.out.println("rotate"+num);
		char[] tmp = a[num].clone();
		if(d==1) {
			a[num][0] = tmp[7];
			for(int i=0;i<7;i++) {
				a[num][i+1] = tmp[i];
			}
		}else {
			a[num][7] = tmp[0];
			for(int i=1;i<8;i++) {
				a[num][i-1] = tmp[i];
			}
		}
	}
	static void init() {
		for(int i=1;i<5;i++) {
			v[i] = false;
		}
	}
	static void print() {
		System.out.println();
		for(int i=1;i<=4;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		//System.out.println();
	}
	static void solve(int num,int d) {
		char tmp[][] = a.clone();
		if(num < 1 || num > 4) return;
		if(num == 1) {
			if(tmp[num][2] != tmp[num+1][6]) { //num기준 오른쪽톱니 
				if(!v[num] || !v[num+1]) {
					rotate(num,d);
					rotate(num+1,d*(-1));
					v[num] = true;
					v[num+1] = true;
					solve(num+1,d*(-1));
				}
			}
		}
		else if(num == 2 || num == 3) {
			if(tmp[num-1][2] != tmp[num][6]) { //num기준 왼쪽 톱니 
				if(!v[num-1] || !v[num]) {
					rotate(num,d);
					rotate(num-1,d*(-1));
					v[num-1] = true;
					v[num] = true;
					solve(num-1,d*(-1));
				}
			}
			if(tmp[num][2] != tmp[num+1][6]) { //num기준 오른쪽톱니 
				if(!v[num] || !v[num+1]) {
					rotate(num,d);
					rotate(num+1,d*(-1));
					v[num] = true;
					v[num+1] = true;
					solve(num+1,d*(-1));
				}
			}
		}
		else if(num == 4){
			if(tmp[num-1][2] != tmp[num][6]) { //num기준 왼쪽 톱니 
				if(!v[num] || !v[num-1]) {
					rotate(num,d);
					rotate(num+1,d*(-1));
					v[num] = true;
					v[num+1] = true;
					solve(num+1,d*(-1));
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = new char[5][8];
		v = new boolean[5];
		for(int i=1;i<5;i++) {
			String s = sc.nextLine();
			for(int j=0;j<8;j++) {
				a[i][j] = s.charAt(j);
			}
		}
		k = sc.nextInt();
		for(int i=0;i<k;i++) {
			int num = sc.nextInt();
			int d = sc.nextInt();
			init();
			solve(num,d);
			print();
		}
		int ans = 0;
		for(int i=1;i<=4;i++) {
			if(a[i][0] == '1') ans += (int) Math.pow(2, i-1);
		}
		System.out.println(ans);
		
	}
}
