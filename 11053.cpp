#include <bits/stdc++.h>
using namespace std;

int arr[1001], dp[1001];
int result=1;

int main(){
    int n;
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }
    fill(dp, dp+n, 1);
    for(int i=1; i<n; i++){
        for(int j=0; j<i; j++){
            if(arr[i]>arr[j]){
                dp[i]=max(dp[i], dp[j]+1);
            }
        }
        result=max(result, dp[i]);
    }
    cout<<result;
    return 0;
}
