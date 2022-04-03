#include <bits/stdc++.h>
using namespace std;

char board[128][128];
int white, blue;

void solve(int a, int b, int n) {
    if (n < 1) return;
    int flag = 0;
    char col = board[a][b];
    for(int i=a; i<a+n; i++) {
        for(int j=b; j<b+n; j++) {
            if(col != board[i][j]) { // 분할 정복
                solve(a, b, n/2);
                solve(a+n/2, b, n/2);
                solve(a, b+n/2, n/2);
                solve(a+n/2, b+n/2, n/2);
                flag = 1;
                break;
            }
        }
        if(flag) break;
    }
    if (!flag) {
        if(col == '0') white++;
        else blue++;
    }
}

int main() {
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> board[i][j];
        }
    }
    solve(0, 0, n);
    cout << white << '\n';
    cout << blue << '\n';
    return 0;
}
