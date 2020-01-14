package aa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//3차원 배열로 만드니까 안됐던게 2차원 copy맵으로 하니까 통과됨!! 
public class E2382 {
	static int N,M,K,ans;
	static Dot map[][],copy[][];
	static int dr[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우 
	static void move(int t) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].cnt <= 0) continue;
				Dot dot = map[i][j];
					int nx = i + dr[dot.d][0];
					int ny = j + dr[dot.d][1];
					int nd = dot.d;
					int ncnt = dot.cnt;
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
						ncnt /=2;
						if(dot.d == 1) nd = 2;
						if(dot.d == 2) nd = 1;
						if(dot.d == 3) nd = 4;
						if(dot.d == 4) nd = 3;
					}
					if(copy[nx][ny].max < ncnt) {
						copy[nx][ny].cnt += ncnt;
						copy[nx][ny].d = nd;
						copy[nx][ny].max = ncnt;
					}
					else {
						copy[nx][ny].cnt += ncnt;
					}
			}
		}
	}
	static void in(Dot a[][],Dot b[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	static void print(int t) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j].cnt+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ans = 0;
			map = new Dot[N][N];
			copy = new Dot[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<=M;k++) {
						map[i][j] = new Dot(0,0);
					}
				}
			}
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                map[x][y] = new Dot(c,v);
                
            }
			int time = 0;
			while(time < M) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						copy[i][j] = new Dot(0,0);
					}
				}
				move(time);
				in(map,copy);
				time++;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j].cnt>0) ans += map[i][j].cnt;
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
		
	}
	static class Dot{
		int cnt,d,max;
		public Dot(int c,int d) {
			this.cnt = c;
			this.d = d;
		}
	}
}
