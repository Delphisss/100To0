#include<bits/stdc++.h>
using namespace std;

bool lower,upper;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string a;
    cin>>a;
    for(auto i:a){
        if(islower(i))lower=true;
        if(isupper(i))upper=true;
    }
    if(lower && upper) cout << "Mix";
    else if(lower) cout<< "All Small Letter";
    else cout << "All Capital Letter";
    return 0;
}