package Algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class test {
    static int n,x,y,eat,big;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
                // 아기 상어 최초 위치
                if(arr[i][j]==9) {
                    x=i;y=j;
                }
            }
        }
        // 먹이 탐색할 때 중복 제거
        visited = new boolean[n][n];
        big = 2;
        
        solve();
    }
    
    // 최적의 먹이를 먹고 다시 먹이 탐색할 때
    private static void init() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                visited[i][j] = false;
        }
    }
    
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
    	eat = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y,0));
        visited[x][y] = true;
        int result = 0;
        
        while(!queue.isEmpty()) {
            int eatX=99,eatY=99; 
            int cnt=0; 
            int size = queue.size();
            
            for(int j=0;j<size;j++) {
                Pair t = queue.poll();
                for(int i=0;i<4;i++) {
                    int tx = t.x+dir[i][0];
                    int ty = t.y+dir[i][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
                    if(visited[tx][ty]) continue;
                    if(arr[tx][ty]>big) continue;
                    visited[tx][ty]=true;
                    queue.add(new Pair(tx,ty,t.cnt+1));

                    if(arr[tx][ty]!=0&& arr[tx][ty]!=big) {

                        if(tx<eatX) {
                            eatY = ty;
                            eatX = tx;
                            cnt = t.cnt+1;
                        }else if(tx==eatX) {
                            if(ty<eatY) {
                                eatY = ty;
                                eatX = tx;
                                cnt = t.cnt+1;
                            }
                        }
                    }
                }
            }
           
            if(eatX!=99) {
                eat++; 
                
                if(eat==big) {
                    big++;
                    eat=0;
                }

                arr[x][y] = 0;
                arr[eatX][eatY] = 9;
                result += cnt;
                x = eatX; y = eatY; 
                init(); 
                queue.clear(); 
                visited[eatX][eatY] = true;
                queue.add(new Pair(eatX,eatY,0));
            }
        }
        System.out.println(result);
    }
    
    static class Pair{
        int x,y,cnt;
        Pair(int x,int y,int cnt){
            this.x = x;
            this.y = y;
//            this.big = big;
//            this.eat = eat;
            this.cnt = cnt;
        }
    }
}