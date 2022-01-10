#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int len;
    string input;
    vector<string> v;

    cin >> input;
    len = input.length();
    v.push_back(input);

    for (int i = 1; i < len; i++) {
        v.push_back(input.substr(i, len));
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << '\n';
    }

    return 0;
}