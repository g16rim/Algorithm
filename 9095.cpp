#include <iostream>
using namespace std;

int f(int n){
    int a[11];
    a[1] = 1;
    a[2] = 2;
    a[3] = 4;
    
    if (n >= 4) {
        for (int i = 4; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }
        return a[n];
    }
    else return a[n];
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << f(n) << '\n';
    }
    return 0;
}
