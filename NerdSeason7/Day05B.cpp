// Date - 03/07/26

// Answer - 5

#include <iostream>
using namespace std;
int gcd(int a , int b){
    if(b == 0){
        return a;
    }
    return gcd(b, a % b);
}

void solve(){
    int k, n;
    cin >> k >> n;
    
    for(int i = 0; i < n; i++){
        int num;
        cin>> num;
        
        int result = gcd(k, num);
        
        if(result > 1){
            cout << result << " ";
        }
        else{
            cout << -1 << " ";
        }
    }
}

int main() {
    solve();
    return 0;
   
}
