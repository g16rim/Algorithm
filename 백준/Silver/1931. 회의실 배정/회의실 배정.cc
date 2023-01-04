#include <iostream>
#include <algorithm>
using namespace std;
#define NMAX 100000
struct appointment {
	int st, et;
	bool operator<(const appointment& b) {
		if (et != b.et)
			return et < b.et;
		else
			return st < b.st;
	}
} meet[NMAX+1];
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> meet[i].st >> meet[i].et;
	}
	sort(meet, meet + n);
	int t = -1;
	int result = 0;
	for (int i = 0; i < n; i++) {
		if (meet[i].st >= t) {
			t = meet[i].et;
			result += 1;
		}
	}
	cout << result;
}