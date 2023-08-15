#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    int mi = 2e9, mx = -2e9;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        mi = min(mi, x);
        mx = max(mx, x);
    }
    cout << mi << "\n" << mx;
    
    return 0;
}