#include <bits/stdc++.h>
using namespace std;

int n, m, cnt;
char maze[100][100];
bool visited[100][100];
queue<pair<pair<int, int>, int>> q;    
    
void bfs(int x, int y) {
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    
    q.front().second++;
    
    visited[x][y] = true;
    
    while(!q.empty()) {
        int nx, ny;
        if ((q.front().first.first+1) == n && (q.front().first.second+1) == m) {
            cout << q.front().second << '\n';
            return;
        }
        for (int i = 0; i < 4; i++) {
            nx = q.front().first.first + dx[i];
            ny = q.front().first.second + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 미로 안
                if (maze[nx][ny] == '1' && visited[nx][ny] == false) { // maze에 길이 있고 && 간 적 없었으면
                    q.push(make_pair(make_pair(nx, ny), q.front().second + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        q.pop();
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> maze[i][j];
            visited[i][j] = false;
        }
    }
    q.push(make_pair(make_pair(0, 0), 0));
    bfs(0, 0);
}
