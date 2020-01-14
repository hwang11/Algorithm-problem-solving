package aaa;

import java.util.LinkedList;
import java.util.Scanner;

/*구현문제  
 *선수 순서를 순열로 배치함 dfs
 * 4번타자는 1번 선수로 고정 
 * 홈 지나면 득점해주면됨 
 * 이 코드 런타임에러 테케는 제대로 나옴 문제가뭔지 모르겠다 
*/
public class B17282 {
	static int N, max, cnt;
	static int arr[][];
	static int v[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static void dfs(int n) {
		if (n == 10) {
			cal();
			cnt++;
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (i == 4)
				continue;
			if (v[i] == 0) {
				v[i] = n;
				dfs(n + 1);
				v[i] = 0;
			}
		}

	} // 순서정하기

	static void cal() {
		int score = 0;
		int starter = 1;
		boolean stop = false;
		for (int i = 0; i < N; i++) {
			int out = 0;
			stop = false;
			boolean base[] = new boolean[4];
			while (true) {
				for (int j = starter; j < 10; j++) {
					int num = arr[i][v[j]];
					if (num == 1) { // 안타
						if (base[3]) {
							score++;
							base[3] = false;
						}
						for (int r = 2; r >= 1; r--) {
							if (base[r]) {
								base[r] = false;
								base[r + 1] = true;
							}
						}
						base[1] = true;
					} else if (num == 2) { // 2루타
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							base[1] = false;
							base[3] = true;
						}
						base[2] = true;

					} else if (num == 3) { // 3루타
						for (int r = 1; r <= 3; r++) {
							if (base[r]) {
								score++;
								base[r] = false;
							}
						}
						base[3] = true;
					} else if (num == 4) { // 홈런
						for (int r = 1; r <= 3; r++) {
							if (base[r]) {
								score++;
								base[r] = false;
							}
						}
						score++; // 타자도 홈으로.
						}
						else if (num == 0) { // 아웃
		                    out++;
		                    if (out == 3) {
		                    	stop = true;
		                    	starter = j +1;
		                    	if(starter == 10) starter = 1;
		                        break;
		                    }
		                }
					if(!stop && j == 9) starter = 1;
					
				}
				if (stop)
					break; // 경기종료
				starter = 1;
			}
		}
		max = Math.max(max, score);
	} // 점수계산

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[10][10];
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		v[4] = 1;
		dfs(2);
		System.out.println(max);
	}

}
