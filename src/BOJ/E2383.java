package BOJ;

import java.util.Scanner;

public class E2383 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int map[][] = new int[n+1][n+1];
			Dot s[] = new Dot[2];
			Pe p[] = new Pe[11];
			int num = 0;
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					map[j][k] = sc.nextInt();
					if(map[j][k]>1) {
						s[num] = new Dot(j,k,map[j][k]);
						num++;
					}
				}
			}
			int num2 = 0;
			//각 사람마다 총 이동해야하는거리.
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(map[j][k] == 1) {
						int m = Math.abs(j-s[0].x) + Math.abs(k-s[0].y); //계단까지가는길.
						int m2 = Math.abs(j-s[1].x) + Math.abs(k-s[1].y);
						if(m<m2) {
							p[num2] = new Pe(m+s[0].l+1,0);
						}
						else if(m==m2) p[num2] = new Pe(m+s[0].l+1,0);
						else p[num2] = new Pe(m2+s[1].l+1,1);
						num2++;
					}
				}
			}
			int time = 1;
			int s1 = 0;
			int s2 = 0;
			int cnt = 0; // 다 내려간 사람 수.
			
			while(cnt < num2) {
				for(int j=0;j<num2;j++) {
					if(p[j].sl == 0) {
						if(p[j].c == 0) s1--;
						else s2--;
						cnt++;
					}
					else {
						if(p[j].c == 0) {
							if(p[j].sl == s[0].l) {
								if(s1 > 3) continue; //3명넘으면 멈추라고.
								if(time == p[j].sl - s[0].l) s1++;
							}
						}
						else {
							if(p[j].c == 1) {
								if(p[j].sl == s[1].l) {
									if(s2 > 3) continue;
									if(time == p[j].sl - s[1].l) s2++;
								}
							}
						}
						p[j].sl--;
					}

				}
				time++;

			}
			System.out.println("time"+time);
		
		}
	}
	
	public static class Dot{ //계단 정보.
		int x;
		int y;
		int l;
		public Dot(int x,int y,int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	public static class Pe{ //사람들이 이동해야하는거리.
		int sl; //길이.
		int c; //계단 구분.
		public Pe(int a,int b) {
			this.sl = a;
			this.c = b;
		}
	}
}
