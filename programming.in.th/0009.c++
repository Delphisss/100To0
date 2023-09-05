#include <iostream>
#include <algorithm>
using namespace std;

int a[3];
char str[4];
int main() {
  for(int i = 0; i < 3; i++) scanf("%d", &a[i]);
  scanf("%s", str);
  sort(a, a+3);
  for(int i = 0; i < 3; i++) {
    printf("%d ", a[str[i] - 'A']);
  }
}
