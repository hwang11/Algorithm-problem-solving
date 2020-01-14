package aaa;

import java.util.Scanner;

public class B14890 {
	static int N,L,ans;
	static int map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int j =0;
	    for (int i = 0; i < N; i++) {
	        int cnt = 1;
	        for (j = 0; j < N - 1; j++) {
	            if (map[i][j] == map[i][j + 1]) cnt++;
	            else if (map[i][j] + 1 == map[i][j + 1] && cnt >= L) cnt = 1;
	            else if (map[i][j] - 1 == map[i][j + 1] && cnt >= 0) cnt = -L + 1;
	            else break;
	        }
	        if (j == N - 1 && cnt >= 0) ans++;
	        cnt = 1;
	        for (j = 0; j < N - 1; j++) {
	            if (map[j][i] == map[j + 1][i]) cnt++;
	            else if (map[j][i] + 1 == map[j + 1][i] && cnt >= L) cnt = 1;
	            else if (map[j][i] - 1 == map[j + 1][i] && cnt >= 0) cnt = -L + 1;
	            //내려가는 중인데 또내려가려면 cnt가 음수인 상태임 그 전껄 다 완료하지 않았기때문에! 
	            //그래서 조건이 cnt>=0 0이되어야 활주로를 완성한 것 
	            else break;
	        }
	        if (j == N - 1 && cnt >= 0) ans++; //cnt < 0 이면 아직 활주로를 완성을 못한상태라는 뜻이기때문에 
	    }
		System.out.println(ans);
	}
}
