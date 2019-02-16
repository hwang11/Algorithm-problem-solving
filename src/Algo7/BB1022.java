package Algo7;

import java.util.Scanner;

public class BB1022 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a[][] = new int[50][50];
		int r1, c1, r2, c2, m, s;
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		m = 0;
		s = 0;

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int x = i - r1;
				int y = j - c1;
				if (i - j < 0) {
					if (i + j < 0)
						a[x][y] = 4 * i * i + i + 1 - j;
					else
						a[x][y] = 4 * j * j - 3 * j + 1 - i;
				} else {
					if (i + j < 0)
						a[x][y] = 4 * j * j - j + 1 + i;
					else
						a[x][y] = 4 * i * i + 3 * i + 1 + j;
				}
				if (a[x][y] > m)
					m = a[x][y];
			}
		}
		while (m > 0) { // 최댓값의 자리수 계산
			m /= 10;
			s++;
		}

		for (int i = 0; i <= r2 - r1; i++) {
			for (int j = 0; j <= c2 - c1; j++) {
				int num, cnt;
				cnt = 0;
				num = a[i][j];
				while (num > 0) { // 현재 값의 자리수 계산
					num /= 10;
					cnt++;
				}
				for (int k = 0; k < s - cnt; k++) {
					System.out.print(" ");
				}
				System.out.printf("%d ", a[i][j]);
			}
			System.out.println();
		}

	}
}
