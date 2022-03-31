#include <bits/stdc++.h>
using namespace std;

string s;

int main() {
    cin >> s;
    
    if (s.find("A") != string::npos) {
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'B' || s[i] == 'C' || s[i] == 'D' || s[i] == 'F') {
                s[i] = 'A';
            }
        }
        cout << s << '\n';
        return 0;
    }
    else if (s.find("B") != string::npos) {
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'C' || s[i] == 'D' || s[i] == 'F') {
                s[i] = 'B';
            }
        }
        cout << s << '\n';
        return 0;
    }
    else if (s.find("C") != string::npos) {
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'D' || s[i] == 'F') {
                s[i] = 'C';
            }
        }
        cout << s << '\n';
        return 0;
    }
    else {
        for (int i = 0; i < s.length(); i++) {
            s[i] = 'A';
        }
        cout << s << '\n';
        return 0;
    }
}
