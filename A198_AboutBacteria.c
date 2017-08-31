#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int k,b,n,t;
    long long z,x=1;

    scanf("%d %d %d %d",&k,&b,&n,&t);

    while(x*k+b<=t){
        x=x*k+b;
        n--;
    }
    if(n<=0){
        printf("0");
    }else{
    printf("%d",n);
    }
    return 0;
}
