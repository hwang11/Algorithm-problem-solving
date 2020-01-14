package Expert;

import java.util.Scanner;
//줄기ㅍ세포배양문제. 내가 생각했던거 보다 더 쉽고 재밌는 문제
//예상대로 map을 옮겨가며 갱신하는건 맞았고, map의 전체크기 예측하는게 어려웠음. 하지만 그냥 큰 수로 대체해도 될듯 
//나는 bfs로 퍼트리고, dfs로 k만큼 재귀 돌려고 생각햇느데 더 간단ㄷ..
class data{
		//0: 빈공간, 1:비활성상태, 2:활성상태, 3: 죽은상태 
		int Status;
		//lp : life point
		//hp : 죽은 상태: 0 비활성 상태일 경우 증가,활성 상태일 경우 감소.
		int LP,HP;
}
public class NE5653{
	static final int MAXL = 352;
	static int T,N,M,K;
	static data[][][] map;
	static int dir [][] = {{0,-1},{0,1},{1,0},{-1,0}};

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new data[2][MAXL][MAXL];
			//초기화 
			for(int i=0;i<N+K+2;i++) {
				for(int j=0;j<M+K+2;j++) {
					map[0][i][j] = new data();
					map[1][i][j] = new data();
					map[0][i][j].Status = 0;
					map[1][i][j].Status = 0;
				}
			}
			
				//초기 줄기 세포의 라이프 포인트.
			for(int i=0+K/2+1;i<N+K/2+1;i++) {
				for(int j=0+K/2+1;j<M+K/2+1;j++) {
					map[0][i][j].LP = sc.nextInt();
					if(map[0][i][j].LP > 0) {
						map[0][i][j].Status = 1;
						map[0][i][j].HP = 0;
					}
				}
			}
			//줄기 세포가 k시간 내에 분포될 수 잇는 최대 범위.
			N = N+K+2;
			M = M+K+2;
			int CurMap = 0;
			for(int k = 0;k<K;k++) { //k만큼 반복한다. 
				for(int i=0;i<N;i++) 
					for(int j=0;j<M;j++) {
						//죽은 세포일경우 
						if(map[CurMap][i][j].Status == 3) {
							//아무동작 안함 
							map[1-CurMap][i][j].Status = map[CurMap][i][j].Status;
							continue;
						}
						// 비활성 상태일 경우 
						else if(map[CurMap][i][j].Status == 1) {
							//비활성 시간 증가  
							map[1-CurMap][i][j].HP = map[CurMap][i][j].HP + 1;
							map[1-CurMap][i][j].LP = map[CurMap][i][j].LP;
							//비활성 시간이 lp만큼 지낫을 경우 
							if(map[1-CurMap][i][j].HP == map[1-CurMap][i][j].LP) 
								map[1-CurMap][i][j].Status = 2;
							
							else map[1-CurMap][i][j].Status = 1;
						}
						//활성상태일 경우 
						else if(map[CurMap][i][j].Status == 2) {
							//활성상태가 된 후, 첫시간일 경우.
							if(map[CurMap][i][j].HP == map[CurMap][i][j].LP) { //expansion
								for(int d= 0;d<4;d++) {
									int i2,j2;
									i2 = i + dir[d][0];
									j2 = j + dir[d][1];
									
									//줄기 세포가 번식하는 방향이 비어있을 경우 
									if(map[CurMap][i2][j2].Status == 0) {
										//하나의 줄기세포가 번식하려고 하는 경우 
										if(map[1-CurMap][i2][j2].Status == 0) {
											//해당 줄기 세포가 셀을 차지 
											map[1-CurMap][i2][j2].Status = 1; //비활성 상태로 번식 
											map[1-CurMap][i2][j2].LP = map[CurMap][i2][j2].LP;
											map[1-CurMap][i2][j2].HP = 0;	
										}
										//두개 이상의 줄기 세포가 셀에 동시에 번식하려고 하는경우 
								
									//생명력 lp가 높은 줄기 세포가 셀을 차지 
									else if(map[1-CurMap][i2][j2].Status == 1 && map[1-CurMap][i2][j2].LP < map[CurMap][i2][j2].LP) 
										map[1-CurMap][i2][j2].LP = map[CurMap][i2][j2].LP;
									
								}
							}
							}	
							//활성시간 증가 
							map[1-CurMap][i][j].HP = map[CurMap][i][j].HP -1;
							//활성상태 시간ㅇ lp시간 만큼 지났을  경우 
							if(map[1-CurMap][i][j].HP == 0) map[1-CurMap][i][j].Status = 3;
								//줄기세포가 죽음 
							else map[1-CurMap][i][j].Status = 2;
						}
					}
					//다음 상태를 저장해 놓은 map을 현재 map으로 변경.
					CurMap = 1 - CurMap;
				}

		//살아있는 줄기세포 탐색 
			int Answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[CurMap][i][j].Status == 1 || map[CurMap][i][j].Status == 2) Answer++;
				}
			}
			System.out.println("#"+tc+" "+Answer);
		}
		
	}
}

