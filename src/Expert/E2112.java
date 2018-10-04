package Expert;

import java.util.Scanner;

public class E2112 {
	static int d,w,k,ans,cnt;
	static int a[][];
	static int copy[][];
	public static boolean check2() {
		int num = 0;
		int num2 = 0;
		for(int i=0;i<w;i++) { //모든 열.
			for(int j=1;j<d;j++) {//모든 행.
				if(copy[j][i] == copy[j-1][i]) num++;
				else num = 0; //달라지면 다시 시작.
			}
			if(num == k-1) num2++;
		}
		if(num2 == w) return true;
		else return false;
	}//심사통과가능한지. k개 이상인지.
	
	public static boolean check() {
		for(int i=0;i<w;i++) {
			int curr = board[0][i], cnt = 1,total =0;
		}
	}
	
//	public static int into() {
//		int cnt = 0;
//		for(int i=0;i<d;i++) {
//			for(int j=0;j<w;j++) {
//				a[i][j] = 0;
//				if(check()) return cnt;
//			}
//		}
//		return 0;
//		
//	}//투입.
	public static int into(int dep,int p,boolean flag) {
		if(check()) {
			return cnt;
		}
		else {
			for(int i=dep;i<d;i++) {
				for(int j=0;j<w;j++) {
					if(flag == false) {
						copy[i][j] = 0;
					}
					else {
						copy[i][j] = 1;
					}
					cnt++;
				}
				into(dep+1,p+1,flag);
				for(int j=0;j<w;j++) { //다시 되돌리기.
					copy[i][j] = a[i][j];
					cnt--;
				}
				into(dep,p+1,flag);
			}
		}
		return 0;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		//for(int t=1;t<=10;t++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			a = new int[d][w];
			copy = new int[d][w];
			for(int i=0;i<d;i++) {
				for(int j=0;j<w;j++) {
					a[i][j] = copy[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			into(0,0,false);
			into(0,0,true);
			//System.out.println("#"+t+" "+ans);
		//}
		
	}
}
