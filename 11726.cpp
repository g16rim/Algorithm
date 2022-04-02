#include <iostream>
using namespace std;

int a[1001];

int main() {
    int n;
    cin >> n;
    a[1] = 1;
    a[2] = 2;
    if (n >= 3) {
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
            a[i] %= 10007;
        }
    }
    cout << a[n] << '\n';
    return 0;
}
