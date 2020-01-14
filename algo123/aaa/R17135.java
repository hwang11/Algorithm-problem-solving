package aaa;

import java.io.*;
import java.util.*;
 
public class R17135 {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {0, -1, 0}; //왼쪽 가운데 오른쪽 우선순위! 
    public static int[] dy = {-1, 0, 1};
    public static int n, m, d, ans = 0;
    public static boolean[] used;   //nCr 구할 때 사용하는 배열
    public static int[][] map;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        map = new int[n + 1][m];
        used = new boolean[m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        nCr(0, 0);
        System.out.println(ans);
    }
 
    //m개의 자리중 3개의 궁수 자리 선택
    public static void nCr(int idx, int cnt) {
        if (cnt == 3) {
            int[][] nmap = new int[n + 1][m];
            for (int i = 0; i < n + 1; i++) { //배열 복사 
                for (int j = 0; j < m; j++) {
                    nmap[i][j] = map[i][j];
                }
            }
            bfs(nmap);
            System.out.println();
            return;
        }
        for (int i = idx; i < m; i++) {
            if (!used[i]) {
                used[i] = true;
                nCr(i, cnt + 1);
                used[i] = false;
            }
        }
    }
 
    public static void bfs(int[][] nmap) {
        int cnt = 0;
        for (int i = n; i > 0; i--) {   //궁수의 포지션을 한칸씩 앞으로 이동 //적을 이동하는게 X 
            int archerIdx = 0;
            Queue<Pair> q = new LinkedList<>();
            for (int j = 0; j < m; j++) { //방문한 궁수위치 대로 
                //nmap에서 궁수 위치는 2
                if (used[j]) {
                    nmap[i][j] = 2; //궁수 위치 할당 
                    q.add(new Pair(i - 1, j, 1, archerIdx++)); //마주보고있는 한칸 앞 좌표 큐에저장 
                } else {    //궁수 위치가 아니면 0
                    nmap[i][j] = 0;
                }
            }
 
            boolean[] isEnemyFind = new boolean[3];     //각 궁수가 몬스터를 찾았는지
            boolean[][][] visited = new boolean[n][m][3];   //각 궁수가 해당 좌표를 방문했는지
            boolean[][] isAlreadyFindLocation = new boolean[n][m];  //이미 다른 궁수가 찾은 목표물인지
            ArrayList<Pair> alist = new ArrayList<>();
 
            while (!q.isEmpty()) {
                Pair p = q.poll();
                if (isEnemyFind[p.idx]) continue;
                if (nmap[p.x][p.y] == 1) { //그좌표가 적이라면 
                    isEnemyFind[p.idx] = true; //p.idx궁수는 적을 찾았다. 
                    if (!isAlreadyFindLocation[p.x][p.y]) { //다른 궁수가 찾은 적이 아니라면 
                        isAlreadyFindLocation[p.x][p.y] = true; //찾았다고 표시후에 
                        alist.add(p); //list에 추가. 
                        cnt++; //적을 죽인 수 증가 
                    }
                    continue;
                }
                if (!isEnemyFind[p.idx]) { //궁수가 적을 찾지못했다면 
                    visited[p.x][p.y][p.idx] = true; //현재 위치 방문 
                    for (int j = 0; j < 3; j++) { //왼,오,가 순서로 탐색. 아무도 방문하지 않았고 거리 ㄱㅊ으면 큐에 넣음. 
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][p.idx] && p.depth < d) {
                            q.add(new Pair(nx, ny, p.depth + 1, p.idx)); //거리 증가했으므로 +1 
                        }
                    }
                }
            }
            for (int j = 0; j < alist.size(); j++) {
                Pair p = alist.get(j);
                nmap[p.x][p.y] = 0; //죽인 적수 자리는 0으로 대체 
                System.out.println(p.x+","+p.y);
            }
        }
        ans = Math.max(ans, cnt);
    }
 
    public static class Pair {
        int x, y, depth, idx;
 
        public Pair(int x, int y, int depth, int idx) { //depth거리 
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.idx = idx;
        }
    }
}
