#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
#define NMAX 1000
vector<int> adj[NMAX + 1];
int visited[NMAX + 1];
int n, m, v;
void dfs(int pos) {
	cout << pos << ' ';
	visited[pos] = 1;
	for (auto &i:adj[pos])
		if (!visited[i])
			dfs(i);
}
void bfs(int pos) {
	queue<int> q;
	q.push(pos);
	while (!q.empty()) {
		int vertex = q.front(); q.pop();
		if (visited[vertex]) continue;
		cout << vertex << ' ';
		visited[vertex] = 1;
		for (auto &i:adj[vertex])
			if (!visited[i])
				q.push(i);
	}
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> n >> m >> v;
	while (m--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++)
		sort(adj[i].begin(), adj[i].end());
	dfs(v);
	cout << '\n';
	fill(visited, visited + NMAX + 1, 0);
	bfs(v);
}