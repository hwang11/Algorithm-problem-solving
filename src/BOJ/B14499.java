package BOJ;
import java.util.Scanner;
//정답 
public class B14499 {
	static int n,m,x,y,k;
	static int die[];
	static int dr[][] = {{0,1},{0,-1},{-1,0},{1,0}}; //동서북남 
	static int map[][];
	// 1 2 3 4 5 6 
	
	//동 1->4 / 3->1 / 6->3 / 4-> 6 
	//서 4->1 / 6->4 / 3-6 / 1-3
	//북 6-2 / 1-5/ 2-1 / 5-6
	//남 1-2 / 5-1 / 6-5 / 2-6 
	
	public static void solve(int d) {
		int nx = x + dr[d-1][0];
		int ny = y + dr[d-1][1];
		if(nx < 0 || ny < 0 || nx >= n || ny >= m) return; //범위 밖이면 명령 수행 X 
		int tmp[] = die.clone();
		switch(d) {
		case 1: die[3] = tmp[1];
				die[1] = tmp[4];
				die[6] = tmp[3];
				die[4] = tmp[6];
				die[5] = tmp[5];
				die[2] = tmp[2];
				break;
		case 2: die[4] = tmp[1];
				die[1] = tmp[3];
				die[3] = tmp[6];
				die[6] = tmp[4];
				die[5] = tmp[5];
				die[2] = tmp[2];
				break;
		case 3: die[2] = tmp[1];
				die[1] = tmp[5];
				die[5] = tmp[6];
				die[6] = tmp[2];
				die[3] = tmp[3];
				die[4] = tmp[4];
				break;
		case 4: die[5] = tmp[1];
				die[1] = tmp[2];
				die[6] = tmp[5];
				die[2] = tmp[6];
				die[3] = tmp[3];
				die[4] = tmp[4];
				break;
		}
		
		x = nx;
		y = ny;
		if(map[nx][ny] != 0) {
			die[1] = map[nx][ny];
			map[nx][ny] = 0;
		}
		else {
			map[nx][ny]=die[1];
		}
		System.out.println(die[6]); //맨 윗면 
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		die = new int[7];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			int d = sc.nextInt();
			
			solve(d);
		}
		
	}
}
