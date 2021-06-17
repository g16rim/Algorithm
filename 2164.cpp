#include <iostream>
#include <queue>
using namespace std;

int main() {
	queue<int> q;
	int n; cin >> n;

	for (int i = 1; i <= n; i++) q.push(i);

	while (!q.empty()) {
		if (q.size() == 1) break;
		q.pop();
		q.push(q.front());
		q.pop();
	}

	cout << q.front() << '\n';
	return 0;
}