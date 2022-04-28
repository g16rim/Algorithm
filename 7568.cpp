#include <bits/stdc++.h>
using namespace std;

vector<pair<pair<int,int>,int>> v;

void ranking(){
    int cnt;
    for(int i=0; i<v.size(); i++){
        cnt=0;
        for(int j=0; j<v.size(); j++){
            if(i==j) continue;
            if(v[i].first.first < v[j].first.first && v[i].first.second < v[j].first.second) cnt++;
        }
        v[i].second=cnt+1;
    }
}

int main(){
    int n;
    cin>>n;
    while(n--){
        int w, h;
        cin>>w>>h;
        v.push_back({{w,h}, 0});
    }
    ranking();
    for(int i=0; i<v.size(); i++){
        cout<<v[i].second<<' ';
    }
    return 0;
}
