#include <iostream>
using namespace std;

int main()
{
    int n;
    int m;
    cin >> m >> n;
    int arr[m][n];
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cin >> arr[i][j];
        }
    }
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            int a;
            cin >> a;
            arr[i][j]=arr[i][j] + a;
        }
    }
    
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    
return 0;
}