#include <iostream>

using namespace std;

int main(){
    int count = 0;
    int n = 3;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i; j++){
               for(int k = 1; k <= j; k++){
                    for(int l = 1; l <= k; l++){
                        count++;
                    }
                }
        }
    }
    cout << count ;
}