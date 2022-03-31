#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
    int n, result = 0;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int pi;
        cin >> pi;
        v.push_back(pi);
    }
    sort(v.begin(), v.end(), greater<int>());
    for (int i = 0; i < n; i++) {
        result += ((i+1) * v[i]);
    }
    cout << result << '\n';
    return 0;
}
