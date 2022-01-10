#include <iostream>
using namespace std;

int main() {
    int n, temp = 0, pos[30000];
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> pos[i];
    }
    for (int i = 0; i < n - 1; i++) {
        int dist;
        cin >> dist;
        if (pos[i] + dist >= temp) {
            temp = pos[i] + dist;
        }
        if (temp < pos[i + 1]) { ///////////////////////////////////////////////중간에 
            cout << "엄마 나 전역 늦어질 것 같아" << '\n'; /////////////////////끊어지면
            return 0; //////////////////////////////////////////////////////////바로
        } //////////////////////////////////////////////////////////////////////종료
    }
    if (temp >= pos[n - 1]) 
        cout << "권병장님, 중대장님이 찾으십니다" << '\n';
    return 0;
}