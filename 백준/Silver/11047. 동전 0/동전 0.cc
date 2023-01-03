#include <iostream>
using namespace std;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, k; int arr[11]; int count = 0;
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];
	for (int i = n; i > 0; i--) {
		count += k / arr[i];
		k%= arr[i];
	}
	cout << count;
}