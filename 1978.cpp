#include <iostream>
using namespace std;

int main(){
    int n, count=0;
    cin >> n;

    while(n--){
        int num, i;
        cin >> num;
        
        for(i=2; i<num; i++){
            if(num%i==0)
                break;
        }
        if(i==num)
            count++;
    }

    cout << count << endl;
    return 0;
}