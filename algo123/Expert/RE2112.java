package Expert;
//보호필름 .
import java.util.Scanner;

public class RE2112{
	static int board[][];
	static int D,W,K,ans;
	static boolean flag;
	public static boolean check() {
		for(int i=0;i<W;i++) { //한 열 씩 . j,i 반대로!
			int curr = board[0][i], cnt = 1, total = 0;
			for(int j=1;j<D;j++) {
				if(curr == board[j][i]) cnt+=1;
				else {
					total = (cnt > total) ? cnt : total;
					//더 큰 값을 total에 넣음.
					cnt = 1; //cnt 값 다시 초기화.
					curr = board[j][i]; //비교 기준 값 이동.
				}
			}
			total = (cnt > total) ? cnt: total;
			if(total < K) return false; //k는 통과의 기준 1열당.k개가 안되면 모든 열 검사할것도없이 false.
		}
		return true;
	}
	public static void dfs(int depth,int pos,int aim) {
		if(flag) return;
		if(depth == aim) { //aim이 증가되는 시점은 main 문의 for문.
			if(check()) {
				flag = true;
			}
			return;
		}
		int tmp[][] = new int[1][21];
		//depth는 현재 약물투입된 행이 몇개인지 세어주는 거.
		for(int i=pos;i<D;i++) { //i를 pos부터 시작하는 이유 그 다음줄 부터 시작하려고.
			for(int j=0;j<=1;j++) {// 0,1
				for(int k=0;k<W;k++) {
					tmp[0][k] = board[i][k]; //임시로 저장.
					board[i][k] = j; // 0또는 1값을 넣음. 약품투입.
				}
				dfs(depth+1,i+1,aim);
				for(int k=0;k<W;k++) {
					board[i][k] = tmp[0][k]; //되돌리기. map전체 되돌리면 시간초과나서 한 줄만.
				}
			} 
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			flag = false;
			board = new int[D][W];
			for(int i =0;i<D;i++) {
				for(int j=0;j<W;j++) {
					board[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<D;i++) {
				dfs(0,0,i);
				if(flag) { //true면 다 종료.
					ans = i;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
}