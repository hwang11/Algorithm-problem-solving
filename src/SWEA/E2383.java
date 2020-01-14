package Expert;

import java.util.Scanner;


public class E2383 {
	static int MAXN = 11;
	static int MAXT = 11 * 2 + 11 * 11;
	//N : 방의 한 변의 길이,M:사람의 수, s : 계단의 수.
	//map
	//match[x] = y : x번째 사람이 y번째계단을 타도록 결정된 상태.
	static int N;
	static int map[][], match[];
	static int M,S;
	
	static int answer;
	static PT man[], stair[];
	
	static int abs(int x) {
		if(x>=0) return x;
		return -x;
	}
	static int max(int x,int y) {
		if(x>=y) return x;
		return y;
	}
	static int min(int x ,int y) {
		if(x >= y )return y;
		return x;
	}
	//거리계산...
	static int dist(int man_index,int stair_index) {
		int dx = abs(man[man_index].r - stair[stair_index].r);
		int dy = abs(man[man_index].c - stair[stair_index].c);
		return dx + dy;
	}
	
	//각사람이 어느 계단을 이용할지 모두 정해졌을 때에 필요한 시간을 계산하는 함수.
	static void update() {
		//모든 사람들이 계단을 내려가는데 필요한 최소 시간.
		int total_min_time = 0;
		
		//두 계단은 서로독립적이므로 각각에 대해서 계산한다.
		for(int stair_index = 0;stair_index < 2;stair_index++) {
			PT now_stair = stair[stair_index];
			int arrival_time[] = new int[MAXN * 2];
			//arrival_time[t] : 시간이 t일때 계단에 도착하는 사람의 수.
			
			int current_stair[] = new int[MAXT];
			//current_stair[t] : 시간 t일때 계단을 내려가고 있는 사람의 수.
			
			for(int i=0;i<MAXT;i++) current_stair[i] = 0;
			for(int i=0;i<2*MAXN;i++) arrival_time[i] = 0;
			for(int man_index = 0; man_index < M;man_index++) {
				if(match[man_index] == stair_index) {
					arrival_time[dist(man_index,stair_index)+1]++;
				}
			}
			//stair_index번째 계단을 내려가는 사람이 모두 작업ㅇ르 마치기위해 필요한최소시간.
			int now_min_time = 0;
			//r계단에 도착하는오름차순으로 각 사람이 계단을 내려가도록 시뮬레이션.
			for(int time=1;time<=20;time++) {
				//왜 20까지 하는거지.? 
				
				//time에 도착한 사람이 있다면 
				while(arrival_time[time] > 0) {
					arrival_time[time]--;
					
					//해당 계단을 내려가는데 필요한 시간 
					int remain_time = map[now_stair.r][now_stair.c];
					
					//도착한 시점부터 사람 3명이 동시에 내려가고 있지 않을 대에 1칸씩 밑으로 
					for(int walk_time = time; walk_time < MAXT;walk_time++) {
						if(current_stair[walk_time]<3) {
							//System.out.println("current_stair["+walk_time+"] "+current_stair[walk_time]);
							current_stair[walk_time]++; 
							remain_time--;
							
							//계단을 다 내려갔으면 now_min_time갱신 
							if(remain_time == 0) {
								now_min_time = max(now_min_time,walk_time+1);
								break;
							}
						}
					}
				}
			}
			//전체계단을 내려가는데 필요한 최소시간은 (두 계단을 내려가는데필요한 최소시간 중 최대값.
			total_min_time = max(total_min_time,now_min_time);
		}
		//현재 match 상태일 때의 total_min_time을 정답으로 갱신.
		answer = min(answer,total_min_time);
	}	
	static void dfs(int man_index) {
		//모든 사람에 대해 각 사람이 사용할 계단을 다 정했다면 
		if(man_index == M) {
			//해당 상태에서 필요한 시간을 계산하고 정답 갱신 
			update();
			return;
		}
		//man_index번째 사람이 stair_index번째계단을 선택하고, 재귀 호출.
		for(int stair_index = 0; stair_index<2;stair_index++) {
			match[man_index] = stair_index;
			dfs(man_index+1);
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			M = S = 0;
			map = new int[N+2][N+2];
			man = new PT[N*N];
			stair = new PT[2];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1 ) man[M++] = new PT(i,j);
					if(map[i][j] >= 2 ) stair[S++] = new PT(i,j);
				}
			}
			answer = 1000000000;
			match = new int[M];
			dfs(0);
			System.out.println("#"+tc +" "+answer);
		}
	}
	//방에서의 위치를 나타내는 클래스 
	static class PT{
		int r, c;
		//(r,c):r번째 행의 c번째 열.
		public PT(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
