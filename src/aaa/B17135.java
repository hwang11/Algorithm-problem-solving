package aaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 순열로 하면 조합과 다르게 시간초과가 날 수있다 
public class B17135 {
	static int N, M, D,ans,cnt;
	static int map[][];
	static int nmap[][];
	static boolean v[];
	static int dr[][] = {{0,-1},{-1,0},{0,1}}; //d왼가오 

	static void dfs(int dep,int k) {
		if(dep == 3) {
			nmap = new int[N+1][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					nmap[i][j] = map[i][j];
				}
			}
			cnt = 0;
			bfs();

			ans = Math.max(ans, cnt);
		}
		for(int i=0;i<M;i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(dep+1,i);
			v[i] = false;
		}
	}
	static void bfs() {
		for(int i=N;i>0;i--) { //궁수 옮길거야 
			int idx = 0;
			Queue<Dot> q = new LinkedList<Dot>();
			boolean isShoot[] = new boolean[3]; //궁수 모두 다 쐈는지 
			boolean al[][] = new boolean[N][M]; //이미 다른 궁수가 잡은 적인지 
			boolean v1[][][] = new boolean[N][M][3]; // 궁수마다 발자취 
			LinkedList<Dot> li = new LinkedList<Dot>(); //죽인 적 리스트 
			
			for(int j=0;j<M;j++) { //고른 궁수 큐에 넣을거야 
				if(v[j]) {
					q.add(new Dot(i-1,j,1,idx++));  //일단 한발 앞으로 
				}
			}
			while(!q.isEmpty()) {
				Dot dot = q.poll();
				if(isShoot[dot.idx]) continue;
				if(nmap[dot.x][dot.y] == 1) { //큐에 넣은 좌표가 적인지 여기서 확인. 
					isShoot[dot.idx] = true;//겹치든 안겹치든 적을 찾은건 맞음 
					if(!al[dot.x][dot.y]) {
						li.add(dot);
						al[dot.x][dot.y] = true;
						cnt++;
					}
					continue;
				}
				if(isShoot[dot.idx]) continue;
				v1[dot.x][dot.y][dot.idx] = true;
				for(int k=0;k<3;k++) {
					int nx = dot.x + dr[k][0];
					int ny = dot.y + dr[k][1];
					if(nx < 0 || ny < 0 || nx >= i || ny >= M 
							|| v1[nx][ny][dot.idx] || dot.dep >= D) continue;
					q.add(new Dot(nx,ny,dot.dep+1,dot.idx));
				}
			}
			
			for(int h=0;h<li.size();h++) {
				Dot dot = li.get(h);
				nmap[dot.x][dot.y] = 0;

			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N+1][M];
		v = new boolean[M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0,0);
		System.out.println(ans);
	}
	static class Dot{
		int x,y,dep,idx;
		public Dot(int x,int y,int d,int i) {
			this.x = x;
			this.y = y;
			this.dep = d;
			this.idx = i;
		}
	}
}
