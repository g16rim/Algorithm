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
        if (temp < pos[i + 1]) { ///////////////////////////////////////////////�߰��� 
            cout << "���� �� ���� �ʾ��� �� ����" << '\n'; /////////////////////��������
            return 0; //////////////////////////////////////////////////////////�ٷ�
        } //////////////////////////////////////////////////////////////////////����
    }
    if (temp >= pos[n - 1]) 
        cout << "�Ǻ����, �ߴ������ ã���ʴϴ�" << '\n';
    return 0;
}