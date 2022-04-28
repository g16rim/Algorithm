#include <bits/stdc++.h>
using namespace std;

int visited[10002];

void f(int i){
    int temp=i;
    int idx=i;
    while(temp>0){
        idx+=(temp%10);
        temp/=10;
    }
    if(idx<10001) visited[idx]=1;
    return;
}


int main(){
    for(int i=1; i<10001; i++){
       f(i);
    }
    for(int i=1; i<10001; i++){
        if(visited[i]==0) cout<<i<<'\n';
    }
    return 0;
}

/* 
brtue force, 탐색 범위 큰 문제 경우
따로 함수 만들어 공간 확보
*/
