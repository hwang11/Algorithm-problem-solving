package aa;

import java.util.LinkedList;
import java.util.Scanner;

public class R2382 {
	static int N,M,K,ans,same;
	static Mi map[][];
	static Mi2 arr[][];
	static int dr[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static void print() {
		System.out.println();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].cnt+" ");
			}
			System.out.println();
		}
	}
	static void move(int x,int y) {
		//System.out.printf("변화전 : %d,%d cnt:%d,d:%d\n",m.x,m.y,m.cnt,m.d);
		Mi m = map[x][y];
		int nx = x + dr[m.d][0];
		int ny = y + dr[m.d][1];
		if(nx == 0 || ny == 0 || nx == N-1 || ny == N-1) {
			arr[nx][ny].cnt = m.cnt/2;
			if(m.d%2==0) arr[nx][ny].d = m.d-1;
			else arr[nx][ny].d = m.d+1;
		}
		else if(arr[nx][ny].cnt > 0) {
			//System.out.printf("%d,%d %d %d\n",nx,ny,t+1,map[nx][ny][t+1].cnt);
			arr[nx][ny].cnt += m.cnt;
			if(arr[nx][ny].max < m.cnt) {
				arr[nx][ny].max = m.cnt;
				arr[nx][ny].d = m.d;
			}
		}else {
			//System.out.println("ㄱㅊ ");
			arr[nx][ny].d = m.d;
			arr[nx][ny].cnt = m.cnt;
			arr[nx][ny].max = m.cnt;
		}
		//System.out.printf("변화 후 (%d,%d) cnt:%d d:%d\n",nx,ny,map[nx][ny][t+1].cnt,map[nx][ny][t+1].d);
	}
	static int cal() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum += map[i][j].cnt;
			}
		}
		return sum;
	}
	static void insert() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j].cnt = arr[i][j].cnt;
				map[i][j].d = arr[i][j].d;
			}
		}
	}
	static void init() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = new Mi2(0,0,0);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new Mi[N][N];
			arr = new Mi2[N][N];
			init();
			for(int j=0;j<N;j++) {
				for(int l=0;l<N;l++) {
					map[j][l] = new Mi(0,0);
				}
			}
			
			for(int i=0;i<K;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int cnt = sc.nextInt();
				int d = sc.nextInt();
				map[x][y] = new Mi(cnt,d);
			}
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					for(int l=0;l<N;l++) {
						if(map[j][l].cnt > 0) {
							move(j,l);
						}
					}
				}
				insert();
				init();
				//print(i+1);
			}
			//print(M);
			ans = cal();
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	
	static class Mi{
		int cnt,d;
		public Mi(int cnt,int d) {
			this.cnt = cnt;
			this.d = d;
		}
	}
	static class Mi2{
		int cnt,d,max;
		public Mi2(int cnt,int d,int max) {
			this.cnt = cnt;
			this.d = d;
			this.max = max;
		}
	}
}
