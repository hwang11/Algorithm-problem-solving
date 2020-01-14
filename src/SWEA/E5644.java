package Asamsung;

import java.util.LinkedList;
import java.util.Scanner;

public class E5644 {
	static int M,A,ans,ax,ay,bx,by,time,anow,bnow;
	static int p1[],p2[];
	static AP ap[];
	static int dr[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static boolean dis(AP ap,int x,int y) {
		int d = Math.abs(ap.x - x) + Math.abs(ap.y-y);
		if(d<=ap.c) return true;
		return false;
	}
	static void solve() {
		time = 0;
		while(time <= M) {
			int smx = 0;
			int snow = 0;
			for(int i=0;i<A;i++) {
				for(int j=0;j<A;j++) {
					snow = 0;
					anow = 0;
					bnow = 0;
					if((dis(ap[i],ax,ay)) && dis(ap[j],bx,by)) {
						if(i == j) {
							anow = ap[i].p/2;
							bnow = ap[j].p/2;

						}else {
							anow = ap[i].p; //각각 영역의 파워가져감 
							bnow = ap[j].p;
						}
					} 
					else if(dis(ap[i],ax,ay)) anow = ap[i].p;
					else if(dis(ap[j],bx,by)) bnow = ap[j].p;
					snow = anow + bnow;
					smx = Math.max(smx, snow);
				}
			}
			//System.out.printf("t:%d %d a(%d,%d) b(%d,%d)\n",time,smx,ax,ay,bx,by);
			ans += smx;
			if(time < M) {
				ay = ay + dr[p1[time+1]][0];
				ax = ax + dr[p1[time+1]][1];
				by = by + dr[p2[time+1]][0];
				bx = bx + dr[p2[time+1]][1];
			}
			time++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			M = sc.nextInt();
			A = sc.nextInt();
			p1 = new int[M+1];
			p2 = new int[M+1];
			ap = new AP[A];
			
			for(int i=1;i<=M;i++) {
				p1[i] = sc.nextInt();
			}
			for(int i=1;i<=M;i++) {
				p2[i] = sc.nextInt();
			}
			for(int i=0;i<A;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				ap[i] = new AP(x,y,c,p);
			}
			ax = 1; ay = 1; bx = 10; by = 10;
			ans = 0;
			solve();
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static class AP{
		int y;
		int x;
		int c;
		int p;
		public AP(int x,int y,int c,int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
}
