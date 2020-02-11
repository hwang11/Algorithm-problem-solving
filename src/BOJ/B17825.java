//package BOJ;
//
//import java.util.Scanner;
//
//public class B17825 {
//	static int d[];
//	static int ans;
//	static int moveNum[];
//	static int map_score[][];
//	static boolean v[][];
//	static boolean special[][];
//	static player player[];
//	
//	static void setting() {
//		// 각 경로 별 움직여야하는 최대 칸수 
//		moveNum[0] = 21; //주
//		moveNum[1] = 13; //빨
//		moveNum[2] = 17; 
//		moveNum[3] = 23;
//		
//		//특별한 점 체크 
//		special[1][9] = special[1][10] = special[1][11] = special[1][12] = true;
//		special[2][13] = special[2][14] = special[2][15] = special[2][16] = true;
//		special[3][19] = special[3][20] = special[3][21] = special[3][22] = true;
//		special[0][1] = special[0][2] = special[0][3] = special[0][4] = true;
//		
//		for (int i = 1; i <= 20; i++) map_score[0][i] = 2 * i;
//	    map_score[1][6] = 13; map_score[1][7] = 16; map_score[1][8] = 19; map_score[1][9] = 25;
//	    map_score[1][10] = 30; map_score[1][11] = 35; map_score[1][12] = 40;
//	    map_score[2][11] = 22; map_score[2][12] = 24; map_score[2][13] = 25; map_score[2][14] = 30;
//	    map_score[2][15] = 35; map_score[2][16] = 40;
//	    map_score[3][16] = 28; map_score[3][17] = 27; map_score[3][18] = 26; map_score[3][19] = 25;
//	    map_score[3][20] = 30; map_score[3][21] = 35; map_score[3][22] = 40;
//	 
//	    for (int i = 1; i <= 5; i++) map_score[1][i] = map_score[0][i];
//	    for (int i = 1; i <= 10; i++) map_score[2][i] = map_score[0][i];
//	    for (int i = 1; i <= 15; i++) map_score[3][i] = map_score[0][i];
//
//
//	}
//	static STATE GetState(int idx, int c_idx) {
//	    /* 현재의 움직임으로 변하는 윷의 상태를 받아오는 함수 */
//		int prev = player[idx].pos;
//		int next = prev + d[c_idx];
//		int start_circle = player[idx].blue_circle;
//		boolean select_circle = false;
//		boolean finish = false;
//		
//		if(next >= moveNum[idx]) finish = true;
//		if(start_circle == 0) {
//			if(prev == 5 || prev == 10 || prev == 15) {
//				select_circle = true;
//				start_circle = prev/5;
//			}
//		}
//		return new STATE(prev,next,start_circle, select_circle, finish);
//	}
//	static boolean check_special_point(int circle, int pos) {
//	    /* 특별한 점에 다른 윷이 존재하는지 판단하는 함수 */
//		if(circle == 0) {
//			if(pos == 20) { // 40점이 쓰여있는 칸이라면, 모든 경로의 말을 확인해줘야 함 
//				
//			}else {
//				if(v[0][pos]) return false;
//			}
//		}else if(circle == 1) {
//			if(pos == 5) {
//				
//			}else {
//				
//			}
//		}
//		
//	}
//	static boolean check_visit(STATE S, int idx) {
//		/* 현재 윷이 움직일 수 있는지를 판단해주는 함수 */
//	    /* 판단해 줘야 할 것
//	       1. 움직이려는 좌표가 특별한 점인지 ?
//	          - 특별한 점이라면 다른 경로를 통해서 해당 좌표에 있는 놈들도 Check.
//	       2. 움직이려는 좌표에 다른 윷이 존재하는지 ? 
//	    */
//		if(special[S.start_circle][S.next]) {
//			if(!check_special_point(S.start_circle,S.next)) return false;
//		}
//		if(v[S.start_circle][S.next]) {
//			return false;
//		}
//		return true; 
//	}
//	static void MakeState(STATE S,int idx, boolean T) {
//		/* 방문 체크를 하고, 실제로 윷을 옮기는 함수. */
//	    /* T = true 일 경우, 실행 */
//	    /* T = false 일 경우, 실행 취소 */
//
//
//	
//	}
//	static void dfs(int cnt) {
//		if(cnt == 10) {}
//		for(int i=0;i<4;i++) {
//			if(player[i].finish == true) continue;
//			STATE state = GetState(i, cnt);
//			if(check_visit(state,i) == false) continue;
//			MakeState(true);
//			dfs(cnt+1);
//			MakeState(false);
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		d = new int[10];
//		for(int i=0;i<10;i++) {
//			d[i] = sc.nextInt();
//		}
//		moveNum = new int[4];
//		map_score = new int[4][30];
//		v = new boolean[4][30];
//		special = new boolean[4][30];
//		player = new player[4];
//		
//		
//		setting();
//		dfs(0);
//		System.out.println(ans);
//	}
//	
//	static class STATE {
//		int prev,next,start_circle;
//		boolean select_circle, finish;
//		//현재칸, 이동할 칸, 시작한 파란원 번호, 파란원 번호 결정되었는지, 도달여부 
//		public STATE(int p,int n, int sc, boolean select,boolean f) {
//			this.prev = p;
//			this.next = n;
//			this.start_circle = sc;
//			this.select_circle = select;
//			this.finish = f;	
//		}
//	}
//	static class player{
//		//한번이라도 시작한 파랑색 원의 번호,말의 정보, 점수,도착여부 
//		int blue_circle, pos, score;
//		boolean finish;
//	}
//}
