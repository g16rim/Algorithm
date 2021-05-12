#include <iostream>
#include <queue>
using namespace std;

int main(){
    int k, max=-1;
    cin >> k;

    priority_queue<int> pq;

    for(int i=0; i<k; i++){
        int n;
        cin >> n; 
        pq.push(n);
    }

    for(int i=1; i<=k; i++){
        int w = pq.top();
        pq.pop();
        int temp=w*i;
        if(temp>max)
            max=temp;
    }

    cout << max << '\n';
    return 0;
}