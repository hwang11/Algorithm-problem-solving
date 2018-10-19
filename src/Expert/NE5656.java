package Expert;

import java.util.Scanner;

public class NE5656 {
	static int N,W,H, Answer;
	//Data: 초기 벽들의 위치를 저장하는 배열 
	static int [][]Data;
	//Map: 벽들이 폭격을 당한 이 후의 상태를 저장할배열 
	static int [][]Map;
	
	//답이 될 수 없는 큰 값 
	public static void init() {
		Answer = 987654321;
	}
	//폭격 이전의 벽돌의 상태를 Map에 저장 
	public static void block_init() {
		for(int i=0;i<H;i++) {
			for(int k=0;k<W;k++) Map[i][k] = Data[i][k];
		}
	}
	public static boolean bomb_1() {
		for(int i=0;i<H;i++)
			for(int k =0;k<W;k++) 
				//지워야 할 벽들일 경우 
				if(Map[i][k] > 10) {
					//d: 벽들의 숫자(폭발할 벽들 표시를 위해 +10했던 값을 다시 지워줌)
					int d = Map[i][k] - 10;
					//현재 위치의 벽들을 제거 
					Map[i][k] = 0;
					
					int sx = k - d +1; //sx : 제거할 벽들의 왼쪽 경계선.
					int ex = k + d -1; //ex : 제거할 벽들의 오른쪽 경계선.
					if(sx<0) sx = 0; //왼쪽 경계선의 최솟값은 0 
					if(ex >= W) ex = W -1; // 오른쪽 경계선의 최댓값은 W-1
					
					boolean flag = false;
					//좌,우에 제거할 수 있는 범위 내에 있는 벽들 탐색 
					for(int x= sx;x<=ex;x++) //start x 부터 end x 까지 
						//제거할 벽들의 숫자가 1이면 해당 벽들을 지워줌 
						if(Map[i][x] == 1) Map[i][x] = 0;
						//제거할 벽들의 숫자가 1보다 크면 지워야할 벽들로 표시(+10)
						else if(Map[i][x] > 1 && Map[i][x] < 10) { Map[i][x] += 10; flag = true; }
					
					int sy = i - d + 1; //sy: 제거할 벽들의 위쪽 경계선 
					int ey = i + d -1;//ey: 제거할 벽들의 아래쪽 경계선 
					if(sy<0) sy = 0;//위쪽 경계선의 최솟값은 0 
					if(ey >= H) ey = H -1;//아래쪽 경계선 최솟값은 H-1
					//위, 아래에 제거할 수 있는 범위 내에 있는 벽들 탐색 
					for(int y=sy;y<=ey;y++)
						//제거할 벽들의 숫자가 1 이면 해당 벽들을 지워줌 
						if(Map[y][k] ==1) Map[y][k] = 0;
						//제거할 벽들의 숫자가 1보다 크면 지ㅇ워야할 벽들로 표시 + 10
						else if(Map[y][k] > 1 && Map[y][k] < 10) {Map[y][k]+=10; flag = true;}
					//지워야 할 벽들이 남아 있는 경우 return 1;
					if(flag) return true;
				}
				//더이상 폭발할 벽들이 없을 경우 
				return false;
			
	}
	
	//구슬이 명중될 때 벽들을 지움 
	public static void bomb(int x) {
		for(int y=0;y<H;y++)
			//벽들의 숫자가 1일 경우, 해당 벽들을 지워줌 
			if(Map[y][x] == 1) {Map[y][x] = 0; return;}
			//벽들의 숫자가 1이 아니면 지워야할 벽들로 표시 
			else if(Map[y][x] > 1) {Map[y][x] += 10; break;}
		
		boolean flag = true;
		//벽들에 더 이상 폭발할 벽들이 없을 때 까지 벽들을 지워줌 
		while(flag) flag = bomb_1();
	}
	
	//q벽들의 ㅣ빈공간을 제거 
	public static void down() {
		for(int k=0;k<W;k++)
			for(int i=H-1;i>=0;i--) { //아래서 부터 
				//빈공간이 있을 때 
				if(Map[i][k] == 0) {
					//빈공간 보다 위에 
					for(int y= i-1;y>=0;y--) {
						//폭발되지 않으 ㄴ벽들이 있으면 
						if(Map[y][k]!=0) {
							//벽들을 아래로 밀어준다. 
							Map[i][k] = Map[y][k];
							Map[y][k] = 0;
							break;
						}
					}
				}
			}
	}

	//s남아 있는 벽들 count 
	public static void block_check() {
		int cnt = 0;
		for(int i=0;i<H;i++)
			for(int k= 0;k<W;k++)
				if(Map[i][k] > 0) cnt++;
		//d이전 경우 남아있던 벽들보다 더 적은 벽들이 남아 있을 경우 저장 
		if(Answer > cnt) {
			Answer = cnt;
		}
	}
	
	static void solve() {
		//r구슬을 투하할 열의 순서 
		int []B = new int[4];
		for(B[0] = 0;B[0]<W;B[0]++)  //첫ㅈ번째 
			for(B[1] = 0;B[1] < W;B[1]++) { // 두 번 째 
				for(B[2] = 0;B[2]<W;B[2]++) { // 세번 
					for(B[3] = 0;B[3]<W;B[3]++) { //네번 
						block_init();
						for(int i=0;i<N;i++) {
							//구슬 투하 
							bomb(B[i]);
							//빈공간 젝 
							down();
						}
						
						block_check();
						//남은 벽들이 0 일 경우 더 최적의 값을 구할 수 없으므로 종료 
						if(Answer == 0) return;
						//n이 4보다 작을  경우,
						//네번째 값의 변화는 유효하지 않은 값이므로 더 이상 진행하지 않음 
						if(N<4) break;
					}
					if(N < 3) break;
				}
				if(N < 2) break;
			}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Data = new int[15][12];
		Map = new int[15][12];
		
		for(int tc = 1;tc<=T;tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			for(int h=0;h<H;h++)
				for(int w = 0; w<W;w++)
					Data[h][w] = sc.nextInt();
			init();
			solve();
			
			System.out.printf("#%d %d",tc,Answer);
			System.out.println();
		}
	}
}
