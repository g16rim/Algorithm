#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(const pair<int, int> &a, const pair<int, int> &b) {
    return a.second < b.second;
}

int main() {
    int n, cnt = 0;
    vector<pair<int, int>> v;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v.push_back(make_pair(x, i));
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < n; i++) {
        if (v[i].first != v[i + 1].first) {
            v[i].first = cnt;
            cnt++;
        }
        else {
            v[i].first = cnt;
        }
    }

    sort(v.begin(), v.end(), cmp);

    for (auto i : v) {
        cout << i.first << ' ';
    }
    
    return 0;
}