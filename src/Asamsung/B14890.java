package Asamsung;

import java.util.Scanner;

public class B14890 {
	static int N,L,ans;
	static int a[][];
	static void solve() { 
		for(int n=0;n<N;n++) {
			int i = 0;
			int cnt = 1;
			for(i=0;i<N-1;i++) {
				if(a[n][i] == a[n][i+1]) cnt++;
				else if(a[n][i]-1 == a[n][i+1] && cnt >= 0) cnt = -L+1;
				else if(a[n][i]+1 == a[n][i+1] && cnt >= L) cnt = 1;
				else break;
			} 
			if(i==N-1 && cnt>= 0) {
				//System.out.printf("%d 열 \n",n);
				ans++;
			}

			i = 0;
			cnt = 1;
			for(i=0;i<N-1;i++) {
				if(a[i][n] == a[i+1][n]) cnt++;
				else if(a[i][n]-1 == a[i+1][n] && cnt >= 0) cnt = -L+1;
				else if(a[i][n]+1 == a[i+1][n] && cnt >= L) cnt = 1;
				else break;
			}
			if(i==N-1 && cnt>= 0) {
				//System.out.printf("%d 행 \n",n);
				ans++;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		a = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		solve();
		System.out.println(ans);
	}
}
