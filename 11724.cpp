#include <bits/stdc++.h>
using namespace std;

int n, m, cnt;
vector<int> v[1001];
stack<int> st;
bool visited[1001];


void dfs(int node) { // dfs stack 이용
    st.push(node);
    
    while(!st.empty()) {
        int cur = st.top();
        st.pop();
        if (visited[cur]) continue;
        visited[cur] = true;
        for (int i = v[cur].size() - 1; i >= 0; i--) {
            int next = v[cur][i];
            st.push(next);
        }
    }
    
    cnt++;
    return;
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for (int i = 1; i <= n; i++) {
        if (visited[i] == false) dfs(i);
    }
    cout << cnt << '\n';
    return 0;
}
