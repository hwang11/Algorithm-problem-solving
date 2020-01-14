package Algo12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RR4277 {
	static int N,M,K,A,B,ans,end,t;
	static int recep_time[],repair_time[],arrive[];
	static Point recep[],repair[];
	static Queue<Integer> rec_wait,rep_wait;
	static pInfo person[];
	static void solve() {
		while(true) {
			for(int i=1;i<=K;i++) {
				if(arrive[i] == t) rec_wait.add(i);
			}
			for(int i=1;i<=N;i++) {
				if(recep[i].num != 0 && recep[i].t == t) {
					rep_wait.add(recep[i].num);
					recep[i].num = 0;
				}
			}
			for(int i=1;i<=M;i++) {
				if(repair[i].num != 0 && repair[i].t == t) {
					repair[i].num = 0;
					end++;
				}
			}
			for(int i=1;i<=N;i++) { //접수대 배치 
				if(rec_wait.isEmpty()) break;
				if(recep[i].num == 0) {
					recep[i].t = t + recep_time[i];
					recep[i].num = rec_wait.poll();
					person[recep[i].num].recN = i;
				}
			}
			

			for(int i=1;i<=M;i++) {//정비 배치 
				if(rep_wait.isEmpty()) break;
				if(repair[i].num == 0) {
					repair[i].t = t + repair_time[i];
					repair[i].num = rep_wait.poll();
					person[repair[i].num].repN = i;
				}
			}
			if(end == K) {
				for(int i=1;i<=K;i++) {
					if(person[i].recN == A && person[i].repN == B) {
						ans += i;
					}
				}
				return;
			}
			t++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		for(int tc=1;tc<=tt;tc++) {
			end = 0;
			t = 0;
			ans = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			recep_time = new int[N+1];
			repair_time = new int[M+1];
			arrive = new int[K+1];
			recep = new Point[N+1];
			repair = new Point[N+1];
			person = new pInfo[K+1];
			rec_wait = new LinkedList<Integer>();
			rep_wait = new LinkedList<Integer>();
			for(int i=1;i<=N;i++) {
				recep_time[i] = sc.nextInt();
				recep[i] = new Point(0,recep_time[i]);
			}
			for(int i=1;i<=M;i++) {
				repair_time[i] = sc.nextInt();
				repair[i] = new Point(0,repair_time[i]);
			}
			for(int i=1;i<=K;i++) {
				arrive[i] = sc.nextInt();
				person[i] = new pInfo(0,0);
			}
			
			solve();
			if(ans == 0) ans =-1;
			System.out.printf("#%d %d\n",tc,ans);
		}
		
	}
	static class Point{
		int num;
		int t;
		public Point(int num,int t) {
			this.num = num;
			this.t = t;
		}
	}
	static class pInfo{
		int recN;
		int repN;
		public pInfo(int recN,int repN) {
			this.recN = recN;
			this.repN = repN;
		}
	}
}
