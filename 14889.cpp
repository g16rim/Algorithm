#include <bits/stdc++.h>
using namespace std;
// 사용하는 변수 초기화! 
int n, result=INT_MAX;
int s[20][20];
vector<int> st, li;

void f(int level) {
    if(level==n/2){
        int visited[n];
        fill(visited, visited+n, 0);
        int temp1 = 0;
        int temp2 = 0;
        for(int i=0; i<st.size(); i++){
            visited[st[i]] = 1;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]) li.push_back(i); 
        }
        
        for(int i=0; i<st.size(); i++){
            for(int j=i+1; j<st.size(); j++){
                temp1 += (s[st[i]][st[j]] + s[st[j]][st[i]]);
                temp2 += (s[li[i]][li[j]] + s[li[j]][li[i]]);
            }
        }
        
        int diff;
        if(temp1>temp2){
           diff = temp1-temp2;
        } else diff = temp2-temp1;
        
        if(result>diff){
            result = diff;
        } 
        
        li.clear();
        return;
    }
    if(st.back()==n) return;
    for(int i=st.back(); i<n-1; i++){
        st.push_back(i+1);
        f(level+1);
        st.pop_back();
    }
}

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> s[i][j];
        }
    }
    
    for(int i=0; i<n; i++){
        st.push_back(i);
        f(1);
        st.pop_back();
    }
    cout << result;
    return 0;
}
