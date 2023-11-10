#include <bits/stdc++.h>
using namespace std;

int n, result = 0;
int t[1000], p[1000];

void solve(int day, int profit){
    if(day==n) result=max(result, profit);
    if(day>=n) return;
    solve(day+t[day], profit+p[day]);
    solve(day+1, profit);
}

int main(){
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>t[i]>>p[i];
    }
    solve(0, 0);
    cout<<result<<'\n';
    return 0;
}