package aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4014 {

	static int N,X,count;
	static int[][] map;
    
	static boolean[][] garo;
	static boolean[][] sero;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
            
             //해당 위치에 경사로가 있는지 체크해줄 배열
			garo = new boolean[N][N];
			sero = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			
            //모든 행 검사
			checkGaro();
            
            //모든 열 검사
			checkSero();
			
			System.out.println("#"+tc+" "+count);
		}
	}
	
	static void checkGaro() {
		
		
		//모든 행을 검사 
		for(int i=0; i<N; i++) {
			boolean ok = true;
			
			//각 행에서 높이를 검사 
			for(int j=0; j<N-1; j++) {
				
                //높이가 같다면 다음 칸 비교로 넘어간다.
				if(map[i][j] == map[i][j+1]) {
					continue;
				}
				
                //앞의 칸이 뒤의 칸보다 더 큰 경우
				if(map[i][j] > map[i][j+1]) {
					if(map[i][j] - map[i][j+1] > 1) {
						//차이가 1보다 커서 경사로를 놓을 수 없다. 
						ok = false;
						break;
					}
					
					if(j+X >= N) {
						//경사로를 놓으면 범위를 벗어난다.
						ok = false;
						break;
					}
					
					for(int k=j+1; k<=j+X; k++) {
						//경사로를 놓을 칸의 높이가 모두 같은지 검사 
						if(map[i][j+1] != map[i][k]) {
							ok = false;
							break;
						}
						
						//경사로가 이미 놓여져있는지 확인 
						if(garo[i][k]) {
							ok = false;
							break;
						}
					}
					
                    
                    //바로 위의 반복문에서 ok는 false값으로 break되어 나올 경우 break해준다.
					if(!ok) break;
					
                    
					//경사로를 놓는다.
					for(int k=j+1; k<=j+X; k++) {
						garo[i][k] = true;
					}
					
					
					//뒤의 칸이 앞의 칸보다 큰 경우
				} else if(map[i][j] < map[i][j+1]) {
					if(map[i][j+1] - map[i][j] > 1) {
						ok = false;
						break;
					}
					
					if(j+1-X < 0) {
						//경사로를 놓으면 범위를 벗어난다.
						ok = false;
						break;
					}
					
					for(int k=j; k>=j+1-X; k--) {
						//경사로를 놓을 칸의 높이가 모두 같은지 검사 
						if(map[i][j] != map[i][k]) {
							ok = false;
							break;
						}
						
						//경사로가 이미 놓여져있는지 확인 
						if(garo[i][k]) {
							ok = false;
							break;
						}
					}
					
					if(!ok) break;
					
					//경사로를 놓는다.
					for(int k=j; k>=j+1-X; k--) {
						garo[i][k] = true;
					}
				}
	
			}
			
            //해당 행이 모든 조건을 만족하여 ok가 true 값을 가지면 count값을 증가
			if(ok) {
				System.out.println(i);
				count++;
			}
		}
	}
	
	static void checkSero() {
		
		//모든 열을 검사 
		for(int j=0; j<N; j++) {
			boolean ok = true;
			
			//각 열에서 높이를 검사 
			for(int i=0; i<N-1; i++) {
				
                //높이가 같다면 다음 칸으로 넘어간다.
				if(map[i][j] == map[i+1][j]) {
					continue;
				}
				
                //앞의 칸이 뒤의 칸보다 더 큰 경우
				if(map[i][j] > map[i+1][j]) {
					if(map[i][j] - map[i+1][j] > 1) {
						//차이가 1보다 커서 경사로를 놓을 수 없다. 
						ok = false;
						break;
					}
					
					if(i+X >= N) {
						//경사로를 놓으면 범위를 벗어난다.
						ok = false;
						break;
					}
					
					for(int k=i+1; k<=i+X; k++) {
						//경사로를 놓을 칸의 높이가 모두 같은지 검사 
						if(map[i+1][j] != map[k][j]) {
							ok = false;
							break;
						}
						
						//경사로가 이미 놓여져있는지 확인 
						if(sero[k][j]) {
							ok = false;
							break;
						}
					}
					
					if(!ok) break;
					
					//경사로를 놓는다.
					for(int k=i+1; k<=i+X; k++) {
						sero[k][j] = true;
					}
					
					
				//뒤의 칸이 앞의 칸보다 더 큰 경우
				} else if(map[i][j] < map[i+1][j]) {
					if(map[i+1][j] - map[i][j] > 1) {
						ok = false;
						break;
					}
					
					if(i+1-X < 0) {
						//경사로를 놓으면 범위를 벗어난다.
						ok = false;
						break;
					}
					
					for(int k=i; k>=i+1-X; k--) {
						//경사로를 놓을 칸의 높이가 모두 같은지 검사 
						if(map[i][j] != map[k][j]) {
							ok = false;
							break;
						}
						
						//경사로가 이미 놓여져있는지 확인 
						if(sero[k][j]) {
							ok = false;
							break;
						}
					}
					
					if(!ok) break;
					
					//경사로를 놓는다.
					for(int k=i; k>=i+1-X; k--) {
						sero[k][j] = true;
					}
				}
						
			}
			
			if(ok) {
				System.out.println("열 "+j);
				count++;
			}
		}
	}

}
