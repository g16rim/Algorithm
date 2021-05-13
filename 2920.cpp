#include <iostream>
using namespace std;

int note[9];

int main(){
    bool asc=true;
    bool des=true;;

    for(int i=0; i<8; i++)
        cin >> note[i];

    for(int i=0; i<8; i++){
        if(note[i]!=(i+1)){
            asc=false;
            break;
        }
    }
    for(int i=0; i<8; i++){
        if(note[i]!=(8-i)){
            des=false;
            break;
        }
    }

    if(asc)
        cout << "ascending";
    else if(des)
        cout << "descending";
    else
        cout << "mixed";

    return 0;
}