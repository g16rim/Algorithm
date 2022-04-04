#include <iostream>
using namespace std;

int r, c, cnt;

void solve(int N, int a, int b) {
    if(a==r && b==c) {
        cout << cnt << '\n';
        return;
    }
    if(r>=a && r<a+N && c>=b && c<b+N) {
        solve(N/2, a, b);
        solve(N/2, a, b+N/2);
        solve(N/2, a+N/2, b);
        solve(N/2, a+N/2, b+N/2);
    }
    else {
        cnt += N*N;
    }
}

int main() {
    int N;
    cin >> N >> r >> c;
    solve(1 << N, 0, 0);
    return 0;
}
