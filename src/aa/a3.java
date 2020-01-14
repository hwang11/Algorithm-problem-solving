package aa;

import java.util.LinkedList;
import java.util.Queue;

public class a3 {
	static int arr[][];
	static boolean v[][];
	static Queue<Dot> q1 = new LinkedList<Dot>();
	static int d[][] = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
	static void bfs(int N) { //map의 값 지정하기. 지뢰가 인접해있는만큼 수를 세야함.  
		while(!q1.isEmpty()) {
			Dot dot = q1.poll();
			for(int i=0;i<8;i++) {
				int nx = dot.x + d[i][0];
				int ny = dot.y + d[i][1];
				if(nx < 1 || ny < 1 || nx> N || ny > N) continue;
				arr[nx][ny]++;
			}
		}
	}
	static int bfs2(int x,int y,int N) { //연속적으로 터지는 개수 세기 
		//0이면 큐에 넣음 인접한 8곳을 또 봐야하므로. 
		int sum = 0;
		Queue<Dot> q = new LinkedList<Dot>();
		if(arr[x][y] == 0) {
			q.add(new Dot(x,y));
			v[x][y] = true;
			sum++;
		}
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i=0;i<8;i++) {
				int nx = dot.x + d[i][0];
				int ny = dot.y + d[i][1];
				if(nx < 1 || ny < 1 || nx> N || ny > N) continue;
				if(v[nx][ny]) continue;
				if(arr[nx][ny] == -1) return sum; //지뢰 발견 종료. 
				v[nx][ny] = true;
				if(arr[nx][ny] == 0)q.add(new Dot(nx,ny));
				sum++;
			}
		}
		return sum;
	}
	public static int solution(int N, int[][] mine, int[] P) {
		int answer = 0;
		arr = new int[N+1][N+1];
		v = new boolean[N+1][N+1];
		for(int i=0;i<mine.length;i++) {
			int v1 = mine[i][0];
			int v2 = mine[i][1];
			arr[v1][v2] = -1; //지뢰표시 
			q1.add(new Dot(v1,v2)); //지뢰를 기점으로 인접한 부분을 봐야해서 
		}
		bfs(N);
		answer = bfs2(P[0],P[1],N); //p는 시작좌표 
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//9	{{1,2},{2,6},{3,4},{3,8},{4,9},{5,4},{5,8},{6,7},{7,2},{9,1}}	{8,5}	29
		int a[][] = {{1,2},{2,6},{3,4},{3,8},{4,9},{5,4},{5,8},{6,7},{7,2},{9,1}};
		int p[] = {8,5};
		solution(9,a,p);
		
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x =x;
			this.y =y;
		}
	}

}
