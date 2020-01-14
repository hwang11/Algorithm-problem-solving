package Algo12;

import java.util.Queue;
import java.util.Scanner;

public class R2477 {
	static int ans,N,M,K,A,B,t,end_cnt;
	static int recep_time[],repair_time[],arrive[];
	static point recep[],repair[];
	static Queue<Integer> rec_wait,rep_wait;
	static pInfo person[];
	static void init() {
		ans = 0;
		t = 0;
		end_cnt = 0;
	}
	static void solve() {
		while(true) {
			//도달하는 시간이 현재시간과 동일하면 rec 대기에 넣어주기
			for(int i=1;i<=K;i++) {
				if(arrive[i] == t) rec_wait.add(i);
			}
			//접수대 끝난 사람 -> 정비실 대기 넣
			for(int i=1;i<=N;i++) {
				if(recep[i].num != 0 && recep[i].t == t) {
					rep_wait.add(recep[i].num);
					recep[i].num = 0; //일 끝남 
				}
			}
			//정비실 끝난 사람 -> 끝난 사람 숫자 ++
			for(int i=1;i<=M;i++) {
				if(repair[i].num != 0 && repair[i].t == t) {
					repair[i].num = 0;
					end_cnt++; //접수 정비 모두 끝남 
				}
			}
			//접수대 대기 -> 접수대 비어 있으면 넣기
			for(int i=1;i<=N;i++) {
				if(rec_wait.isEmpty()) break;
				if(recep[i].num == 0) {
					recep[i].num = rec_wait.poll();
					recep[i].t = t + recep_time[i]; //recep[i].t는 작업이 끝나는 시간 
					person[recep[i].num].recN = i; // recep배열 들어가 있는 접수대 숫자, 들어간 사람의 숫자, 걸리는 시간 저장

				}
			}
			//정비실 대기 -> 정비실 비어 있으면 넣기
			for(int i=1;i<=M;i++) {
		          if (rep_wait.isEmpty())break;
		            if (repair[i].num == 0) {
		                repair[i].num = rep_wait.poll();
		                repair[i].t = t + repair_time[i];
		                person[repair[i].num].repN = i;
		            }
			}
	        // 결과 확인
	        if (K == end_cnt) {
	            for (int i = 1; i <= K; i++) {
	                if (person[i].recN == A && person[i].repN == B) {
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
		int t;
		t = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		for(int i=1;i<=N;i++) {
			recep_time[i] = sc.nextInt();
		}
		for(int i=1;i<=M;i++) {
			repair_time[i] = sc.nextInt();
		}
		for(int i=1;i<=K;i++) {
			arrive[i] = sc.nextInt();
		}
		solve();
		if(ans == 0) ans =  -1;
		System.out.println(ans);
		init();
	}
	class point{
		int num,t;
	}
	class pInfo{
		int recN, repN;
	}
}
