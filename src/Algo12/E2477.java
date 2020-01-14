package Algo12;

import java.util.LinkedList;
import java.util.Scanner;

public class E2477 {
	static int N,M,K,A,B,ans,time,cnt1,cnt2;
	static int a[],b[];
	static int f[],r[];
	static Per k[];
//	static LinkedList al[],bl[]; //접수 받은 리스트 
	static LinkedList<Per> wait;
	
	//   ① 여러 고객이 기다리고 있는 경우 고객번호가 낮은 순서대로 우선 접수한다.
//	   ② 빈 창구가 여러 곳인 경우 접수 창구번호가 작은 곳으로 간다.

	static boolean rec(int n) { //비교해서 배정하기 
		for(int i=1;i<=N;i++) {
			if(r[i] == 0 || time%a[i] == r[i]) { //접수가 가능하면
				System.out.printf("rec %d\n",n);
				if(r[i] == 0) r[i] = time;
				k[n].kt = 0;
				k[n].ft = a[i]+time; //접수에서 걸리는 시간을 정비하기까지의 시간으로 부여 
				k[n].rn = i; //n번째 고객이 이용한 접수창구번호 저장 
				wait.add(k[n]);
				return true; //배정 됨 
			}
		}
		return false; //기다려야함 
	}
	
//	 ① 먼저 기다리는 고객이 우선한다. ft기준 ?
//	   ② 두 명 이상의 고객들이 접수 창구에서 동시에 접수를 완료하고 정비 창구로 이동한 경우, 이용했던 접수 창구번호가 작은 고객이 우선한다.
//	   ③ 빈 창구가 여러 곳인 경우 정비 창구번호가 작은 곳으로 간다.
	static boolean fix(int n) {
		for(int i=1;i<=M;i++) {
			System.out.printf("fix %d\n",n);
			if(f[i] == 0 || time%b[i]==f[i]) { //접수가 가능하면 
				if(f[i] == 0) f[i] = time;
				k[n].fn = i;
				return true; //배정 됨 
			}
		}
		return false;
	}
	static void solve() {
		while(true) {
			System.out.printf("time %d cnt1 %d cnt2 %d\n",time, cnt1,cnt2);
			if(cnt1 == K && cnt2 == K) {
				System.out.println("종료 ");
				return; //모두 완료가 되었다면 
			}
			for(int i=1;i<=K;i++) {
				if(k[i].kt == time) if(rec(i)) cnt1++; //접수가 아직이고 웨이팅시간이 다 됐다면 
			}
			for(int i=0;i<wait.size();i++) {
				if(time == wait.get(i).ft) {
					if(fix(wait.get(i).num)) {

						cnt2++;
						wait.removeFirst();
					}
				}
			}
			time++;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			ans = 0;
//			al = new LinkedList[N];
//			bl = new LinkedList[M];
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			wait = new LinkedList<Per>();
			r = new int[N+1];
			f = new int[M+1];
			a = new int[N+1];
			b = new int[M+1];
			k = new Per[K+1];
			cnt1 = 0;
			cnt2 = 0;
			for(int i=1;i<=N;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=1;i<=M;i++) {
				b[i] = sc.nextInt();
			}
			for(int i=1;i<=K;i++) {
				int kt = sc.nextInt();
				k[i] = new Per(kt,0,i);
			}
			solve();
			for(int i=1;i<=K;i++) {
				if(k[i].rn == A && k[i].fn == B) ans += i;
			}
			System.out.println(ans);
		}
	}
	
	static class Per{
		int num;
		int kt;
		int ft;
		int rn;
		int fn;
		public Per(int kt,int ft,int num) {
			this.kt = kt;
			this.ft = ft;
			this.num = num;
		}
	}
}
