#include <iostream>
using namespace std;

long long D[1001][1001];

int main(){
    D[1][1]=0;
    for(int i=1; i<=1000; i++){
        D[1][i]=1; D[i][1]=1;
    }

    int n, m;
    cin >> n >> m;

    for(int i=2; i<=n; i++)
        for(int j=2; j<=m; j++){
            D[i][j]=(D[i-1][j-1]+D[i][j-1]+D[i-1][j])%1000000007;
        }

    cout << D[n][m] << '\n';
}