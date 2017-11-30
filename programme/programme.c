#include <stdio.h>
#include <stdlib.h>

int main(){
	// simple multiplication of element from 0 to 50
  int i, j,a;
  for(i = 1; i<=40; i++){
      for(j =1; j<=50; j++){
         a=i*j;
	printf("%d\n", a);
      }    
  }
}
