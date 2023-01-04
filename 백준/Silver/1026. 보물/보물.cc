#include <iostream>
#include <algorithm>
using namespace std;

int N, result;
int A[100], B[100];

bool comp(int m, int n) {
    return n < m;
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> B[i];
    }

    sort(A, A + N);
    sort(B, B + N, comp);

    for (int i = 0; i < N; i++) {
        result += (A[i] * B[i]);
    }

    printf("%d\n", result);

    return 0;
}