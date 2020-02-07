package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class R15683 {
	static int n,m,result;
	static int[][] arr;
	static int[][] copy;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //우 하 좌 상 
	static List<Dot> list = new ArrayList<>();
	public static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}
    private static void print() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
    }
	public static void check(Dot dot) {
		int x = dot.x,y = dot.y;
		switch(dot.n) {
			case 1:
				while(true){
					x = x+dir[dot.r][0];
					y = y+dir[dot.r][1];
					if(x<0 || y<0 || x>=n || y>=m) break; //감시구역 바꿔주기 
					if(copy[x][y] == 0) copy[x][y] = 7;
					else if(copy[x][y] == 6) break;
				}
				break;
			case 2:
				for(int i=0;i<3;i+=2) { //2개만 2씩 차이나게 할거라서..?
					x = dot.x; y = dot.y;//여기서 굳이 한번 더 해주는 이유는? -> x,y가다른데서 변하므로! 
					while(true) {
						x = x+dir[(dot.r+i)%4][0];
						y = y+dir[(dot.r+i)%4][1];
						if(x<0 || y<0 || x>=n || y>=m) break; //감시구역 바꿔주기 
						if(copy[x][y] == 0) copy[x][y] = 7;
						else if(copy[x][y] == 6) break;
						
					}
				}
				break;
			case 3:
				for(int i=0;i<2;i++) { //i는 화살표 개수 
					x = dot.x; y = dot.y;
					while(true) {
						x = x+dir[(dot.r+i)%4][0];
						y = y+dir[(dot.r+i)%4][1];
						if(x<0 || y<0 || x>=n || y>=m) break; //감시구역 바꿔주기 
						if(copy[x][y] == 0) copy[x][y] = 7;
						else if(copy[x][y] == 6) break;
						
					}
				}
				break;
			case 4:
				for(int i=0;i<3;i++) {
					x = dot.x; y = dot.y;
					while(true) {
						x = x+dir[(dot.r+i)%4][0];
						y = y+dir[(dot.r+i)%4][1];
						if(x<0 || y<0 || x>=n || y>=m) break; //감시구역 바꿔주기 
						if(copy[x][y] == 0) copy[x][y] = 7;
						else if(copy[x][y] == 6) break;
						
					}
				}
				break;
			case 5:
				for(int i=0;i<4;i++) {
					x = dot.x; y = dot.y;
					while(true) { //하나의 화살표방향으로 색칠하는 반복문 
						x = x+dir[(dot.r+i)%4][0];
						y = y+dir[(dot.r+i)%4][1];
						if(x<0 || y<0 || x>=n || y>=m) break; //감시구역 바꿔주기 
						if(copy[x][y] == 0) copy[x][y] = 7;
						else if(copy[x][y] == 6) break;
						
					}
				}
				break;
		}
	}
	public static void solve(int idx) {
		if(idx>=list.size()) { //기저조건 
			init();
			for(Dot t:list) {
				//System.out.print(t.r+" ");
				check(t);
			}
			//System.out.println();
			int cnt = 0;
			System.out.println("listsize:"+list.size());
			print();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(copy[i][j]==0) cnt++;
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		for(int i=0;i<=3;i++) {
			list.get(idx).r = i; //방향 순열. 방향리스트를 완성하고 그 다음에 맵을 채움 
			//방문표시는 없어도되는건지 ?
			solve(idx+1); //재귀 
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		copy = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]>0 && arr[i][j]<6) list.add(new Dot(i,j,arr[i][j],0));
			}
		}
		result = Integer.MAX_VALUE;
		solve(0);
		System.out.println(result);
	}
	static class Dot{
		int x,y,n,r;
		public Dot(int x,int y,int n,int r) {
			this.x = x;
			this.y = y;
			this.n = n; //카메라 넘버 
			this.r = r;
		}
	}
}
