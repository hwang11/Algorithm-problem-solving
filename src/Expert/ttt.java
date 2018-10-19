package Expert;


int t, tc;
int N, W, H;
int dx[] = { 0,0,1,-1 }, dy[] = { 1,-1,0,0 };
int map[5][15][12];
 
int dfs(int x, int y, int depth) {
    int siz = map[depth][x][y];
    int ans = 1;
    map[depth][x][y] = 0;
    for (int i = 0; i < siz; ++i) {
        for (int j = 0; j < 4; ++j) {
            int nx = x + i*dx[j];
            int ny = y + i*dy[j];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[depth][nx][ny] == 0) continue;
            ans += dfs(nx, ny, depth);
        }
    }
    return ans;
}
 
void cpy(int depth) {
    for (int i = 0; i < H; ++i) for (int j = 0; j < W; ++j)
        map[depth][i][j] = map[depth - 1][i][j];
}
 
void drop(int depth) {
    queue<int> q;
    for (int j = 0; j < W; ++j) {
        for (int i = H - 1; i >= 0; --i) {
            if (map[depth][i][j]) {
                q.push(map[depth][i][j]);
                map[depth][i][j] = 0;
            }
        }
        for (int i = H - 1; q.size(); --i, q.pop())
            map[depth][i][j] = q.front();
    }
}
 
int run(int depth) {
    if (depth > N) return 0;
    int ans = 0;
    // drop ith
    for (int i = 0; i < W; ++i) {
        cpy(depth);
        int temp = 0;
        bool f = 1;
        for (int j = 0; j < H; ++j) {
            if (map[depth][j][i]) {
                f = 0;
                temp = dfs(j, i, depth);
                break;
            }
        }
        if (f) continue;
        drop(depth);
        ans = max(ans, run(depth + 1) + temp);
    }
    return ans;
}
 
int main() {
    ios::sync_with_stdio(false); cin.tie(0);
    cin >> t;
    for (tc = 1; tc <= t; ++tc) {
        cin >> N >> W >> H;
        int sum = 0;
        for (int i = 0; i < H; ++i) for (int j = 0; j < W; ++j) {
            cin >> map[0][i][j];
            sum += map[0][i][j] ? 1 : 0;
        }
        int ans = sum - run(1);
        cout << "#" << tc << " " << ans << '\n';
    }
    return 0;
}
