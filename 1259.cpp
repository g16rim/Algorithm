#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    while(1){
        cin >> s;
        if (s=="0")
            break;
        int flag = 1;
        for(int i=0; i<s.size()/2; i++){
            if(s[i]!=s[s.size()-1-i]){
                cout << "no\n";
                flag = 0;
                break;
            }
        }
        if (flag)
            cout << "yes\n";
    }
}