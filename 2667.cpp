#include <bits/stdc++.h>
using namespace std;

int n;
char m[26][26];
bool visited[26][26];
stack<pair<int, int>> st;
vector<int> v;

void dfs(int a, int b) {
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    int cnt = 1;
    st.push({a, b});
    while(!st.empty()) {
        int curx = st.top().first;
        int cury = st.top().second;
        st.pop();
        //if (visited[curx][cury]) continue;
        visited[curx][cury] = true;
        for (int i = 0; i < 4; i++) {
            int nx = curx + dx[i];
            int ny = cury + dy[i];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] == true || m[nx][ny] == '0') continue;
            
            st.push({nx, ny});
            visited[nx][ny] = true;
    
            cnt++;
        }
    }
    v.push_back(cnt);
    return;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> m[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (visited[i][j] == false && m[i][j] == '1') dfs(i, j);
        }
    }
    cout << v.size() << '\n';
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << '\n';
    }
    return 0;
}
