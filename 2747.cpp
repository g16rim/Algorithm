// top-down 재귀 호출

#include <bits/stdc++.h>
using namespace std;

int dp[46];

int fibo(int n){
    if(n<=1) return dp[n];
    if(dp[n]!=-1) return dp[n];
    return dp[n]=fibo(n-1)+fibo(n-2);
}

int main(){
    int n;
    cin>>n;
    fill(dp, dp+n+1, -1);
    dp[0]=0;
    dp[1]=1;
    cout<<fibo(n);
    return 0;
}

------------------------------------------------

// bottom-up 반복문
  
#include <bits/stdc++.h>
using namespace std;

int dp[46];

int main(){
    int n;
    cin>>n;
    dp[0]=0;
    dp[1]=1;
    for(int i=2; i<=n; i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    cout<<dp[n];
    return 0;
}
