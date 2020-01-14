package Asamsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E5653 {
	static int N,M,K,ans;
	static Cell map[][];
	static Dot copy[][];
	static int dr[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static Queue<Dot> q[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new Cell[500][500];
			for(int i=0;i<500;i++) {
				for(int j=0;j<500;j++) {
					map[i][j] = new Cell(0,0);
				}
			}
			q = new Queue[11];
			for(int i=1;i<=10;i++) {
				q[i] = new LinkedList<Dot>();
			}
			for(int i=250;i<250+N;i++) {
				for(int j=250;j<250+M;j++) {
					int num = sc.nextInt();
					map[i][j].num = num;
					map[i][j].t = num*2;
					if(num !=0) {
						q[num].add(new Dot(i,j));
					}
				}
			}
			ans = 0;
			for(int k=1;k<=K;k++) {
				for(int i=10;i>0;i--) {
					int qsize = q[i].size();
					for(int l=0;l<qsize;l++){
						Dot d = q[i].poll();
						map[d.x][d.y].t--;
						//map[d.x][d.y].num == map[d.x][d.y].t 일때 활성화된다.
						if(map[d.x][d.y].num > map[d.x][d.y].t) {//번식하는 조건.
							for(int j=0;j<4;j++) {
								int nx = d.x + dr[j][0];
								int ny = d.y + dr[j][1];
								if(map[nx][ny].num == 0) { //그자리가 빈자리이면 제일 수가 큰큐부터 돌기때문에 굳이 정렬이나 비교를 
									//할 필요가 없다.
									map[nx][ny].num = map[d.x][d.y].num;
									map[nx][ny].t = 2*map[d.x][d.y].num;
									q[i].add(new Dot(nx,ny));
								}
							}
						}
						if(map[d.x][d.y].t != 0) { //아직 죽지 않았다면 다시 큐에 넣어줘야한다.
							q[i].add(new Dot(d.x,d.y));
						}
					} 
				}
				//System.out.println(k);
			}
			for(int i=1;i<=10;i++) { //죽을때되면 죽으니까 죽고남은게 큐에남아있음 
				ans += q[i].size();
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
		
	}
	static class Cell{
		int t; //활성화 되는 시간. 
		int num;
		public Cell(int n,int t) {
			this.num = n;
			this.t = t;
		}
	}
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y =y;
		}
	}
}
