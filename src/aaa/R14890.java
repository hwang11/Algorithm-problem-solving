package aaa;

import java.util.Scanner;

public class R14890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int ans = 0;
		int map[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int j = 0;
		int cnt = 1;
		for(int i=0;i<N;i++) {
			j = 0;
			cnt = 1;
			for(j=0;j<N-1;j++) {
				if(map[i][j] == map[i][j+1]) cnt++;
				else if(map[i][j]+1 == map[i][j+1] && cnt >= L) cnt = 1;
				else if(map[i][j]-1 == map[i][j+1] && cnt >= 0) cnt = -L +1;
				else break;
			}
			if(j== N-1 && cnt >= 0) ans++;
			j = 0;
			cnt = 1;
			for(j=0;j<N-1;j++) {
				if(map[j][i] == map[j+1][i]) cnt++;
				else if(map[j][i]+1 == map[j+1][i] && cnt >= L) cnt = 1;
				else if(map[j][i]-1 == map[j+1][i] && cnt >= 0) cnt = -L +1;
				else break;
			}
			if(j== N-1 && cnt >= 0) ans++;
		}
		System.out.println(ans);
	}
}
