#include <iostream>
#include <queue>
using namespace std;
#define NMAX 1000
#define MMAX 1000
int tomato[NMAX + 2][MMAX + 2];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };
int main() {
	int m, n;
	fill(&tomato[0][0], &tomato[NMAX + 1][MMAX + 2], -1);
	queue<pair<int, int>> q;
	cin >> m >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> tomato[i][j];
			if (tomato[i][j] == 1)
				q.emplace(j, i);
		}
	}
	while (!q.empty()) {
		int x = q.front().first; int y = q.front().second;
		q.pop();
		for(int i=0; i<4; i++)
			if (tomato[y + dy[i]][x + dx[i]] == 0) {
				q.emplace(x + dx[i], y + dy[i]);
				tomato[y + dy[i]][x + dx[i]] = tomato[y][x] + 1;
			}
	}
	int day = -1;
	for(int y=1; y<= n; y++)
		for (int x = 1; x <= m; x++) {
			day = max(day, tomato[y][x]);
			if (tomato[y][x] == 0) {
				cout << -1; return 0;
			}
		}
	cout << day - 1;
}