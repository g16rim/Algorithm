#include <iostream>
#include <algorithm>
using namespace std;

int N;
int arr[1000000];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + N);
    for (int i = N - 1; i > 1; i--) {
        if (arr[i] < arr[i - 1] + arr[i - 2]) {
            printf("%d\n", arr[i] + arr[i - 1] + arr[i -2]);
            return 0;
        }
    }
    printf("-1\n");
    return 0;
}