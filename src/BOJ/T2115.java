package BOJ;

import java.util.*;
public class T2115{
    static int[][]map;
    static int N,M,C,ans,ret;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            N=sc.nextInt();
            M=sc.nextInt();
            C=sc.nextInt();
            map=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]=sc.nextInt();
                }
            }
            ans=0;
            dfs(0,0,0);
            System.out.println("#"+t+" "+ans);
        }
    }
    static void dfs(int cnt,int idx,int result){
        if(cnt==2){
            ans=Math.max(ans, result);
            return;
        }
        for(int i=idx;i<N*N;i++){
            int x=i/N;
            int y=i%N;
            if(y>N-M)continue;
            ret=0;
            dfs2(x,y,y+M,0,0);
            dfs(cnt+1,i+M,result+ret);
        }
    }
    static void dfs2(int x,int y,int maxy,int c,int cc){
        if(c>C)return;
        ret=Math.max(ret, cc);
        for(int i=y;i<maxy;i++){
            dfs2(x,i+1,maxy,c+map[x][i],cc+map[x][i]*map[x][i]);
        }
    }
}