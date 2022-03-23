#include <bits/stdc++.h> //////메모리 
using namespace std;

int n, k;
queue<pair<int, int>> q;
bool visited[100001];

void bfs() {
    q.push(make_pair(n, 0));
    visited[n] = true;
    
    while(!q.empty()) {
        int x = q.front().first;
        int cnt = q.front().second;
        
        if (x == k) {
            cout << q.front().second;
            return;
        }
        if (2*x <= 100000 && visited[2*x] == false) {
            visited[2*x] == true;
            q.push(make_pair(2*x, cnt + 1));
        }
        if (x+1 <= 100000 && visited[x+1] == false) {
            visited[x+1] == true;
            q.push(make_pair(x+1, cnt + 1));
        }
        if (x-1 >= 0 && visited[x-1] == false) {
            visited[x-1] == true;
            q.push(make_pair(x-1, cnt + 1));
        }
        q.pop();
    }
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < 100001; i++) visited[i] = false;
    bfs();
}

-------------------------------------------------------------------
    
#include <bits/stdc++.h>
using namespace std;

int visited[100001];
queue<pair<int, int>> q;

void bfs(int n, int k) {
    visited[n] = 1;
    q.push(make_pair(n, 0));
    while(!q.empty()) {
        int x = q.front().first;
        int cnt = q.front().second;
        
        if (x == k) {
            cout << cnt << '\n';
            return;
        }
        
        if (2*x <= 100000 && visited[2*x]==0) {
            q.push(make_pair(2*x, cnt+1));
            visited[2*x] = 1;
        }
        if (x+1 <= 100000 && visited[x+1]==0) {
            q.push(make_pair(x+1, cnt+1));
            visited[x+1] = 1;
        }
        if (x-1 >= 0 && visited[x-1]==0) {
            q.push(make_pair(x-1, cnt+1));
            visited[x-1] = 1;
        }
        
        q.pop();
    }
}

int main() {
    int n, k;
    cin >> n >> k;
    bfs(n, k);
    return 0;
}
