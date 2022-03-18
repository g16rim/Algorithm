#include <bits/stdc++.h>
using namespace std;

int dx[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};
bool visited[300][300];
queue<pair<int, int>> q;
int l, cnt;

void bfs(int tx, int ty, int ex, int ey) {
    cnt++;
    visited[tx][ty] = true;
    q.pop();
    
    while(!q.empty()) {
        for (int i = 0; i < 8; i++) {
            if (tx == ex && ty == ey) {
                cnt++;
                return;
            }
            if (visited[tx][ty] != true && tx + dx[i] >= 0 && tx + dx[i] < l && ty + dy[i] >= 0 && ty + dy[i] < l) {
                // 체스판 안 일때만
                q.push(make_pair(tx + dx[i], ty + dy[i]));
            }
        }
        bfs(q.front().first, q.front().second, ex, ey);   
    }
}

int main () {
    int tc;
    cin >> tc;
    while(tc--) {
        cnt = 0;
        cin >> l;
        int start_x, start_y, end_x, end_y;
        cin >> start_x >> start_y;
        visited[start_x][start_y] = 1;
        cin >> end_x >> end_y;
        
        cout << cnt << '\n';
    }
}
