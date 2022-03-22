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


----------------------------------------------------------------------------------------


#include <bits/stdc++.h>
using namespace std;

int l, tarx, tary;
queue<pair<pair<int, int>, int>> q;
bool visited[301][301];

void BFS() {
    int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    for(int i = 0; i < 301; i++) {
        for(int j = 0; j < 301; j++) {
            visited[i][j] = false;
        }
    }
    
    while(!q.empty()) {
        pair<pair<int, int>, int> temp = q.front();
        q.pop();
        
        int x = temp.first.first;
        int y = temp.first.second;
        
        if (x == tarx && y == tary) {
            cout << temp.second << '\n';
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            // board 안 && !visited 이면 q.push_back
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < l && ny >= 0 && ny < l && visited[nx][ny] == false) {
                q.push(make_pair(make_pair(nx, ny), temp.second + 1));
                visited[nx][ny] = true;
            }
        }
    }
}

int main() {
    int tc;
    cin >> tc;
    while(tc--) {
        int x, y;
        cin >> l;
        cin >> x >> y;
        visited[x][y] = true;
        q.push(make_pair(make_pair(x, y), 0));
        cin >> tarx >> tary;
        BFS(); 
        while(!q.empty()) q.pop(); // queue clear 안 하면 33% 틀림
    }
}
