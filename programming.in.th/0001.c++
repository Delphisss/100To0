#include <iostream>
using namespace std;

int main(){
    int a , b  , c;
    cin >>  a >> b >> c ;
    int x = a+b+c;

    if (x >= 80)
    {
        cout << "A";
    }else if (x>=75)
    {
        cout << "B+";
    }else if (x>=70)
    {
        cout << "B";
    }else if (x>=65)
    {
        cout << "C+";
    }else if (x>=60)
    {
        cout << "C";
    }else if (x>=55)
    {
        cout << "D+";
    }else if (x>=50)
    {
        cout << "D";
    }else
    {
        cout << "F";
    }
    
}