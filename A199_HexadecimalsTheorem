#include <stdio.h>
#include <stdlib.h>

int main()
{

    long long n,t1=2,t2=3,temp;
    long long a[4];
    scanf("%lld",&n);
    a[0]=0;a[1]=1;a[2]=1;a[3]=2;
    while(t2<n){
        a[0]=a[1];
        a[1]=a[2];
        a[2]=a[3];
        a[3]=t2;
        temp=t1;
        t1=t2;
        t2+=temp;
    }
    if(n==3){
        printf("1 1 1");
    }else if(n==0){
        printf("0 0 0");
    }else if(n==1){
        printf("0 0 1");
    }else if(n==2){
        printf("0 1 1");
    }else if(t2==n){
        printf("%lld %lld %lld",a[0],a[1],a[3]);
    }else{
        printf("I'm too stupid to solve this problem");
    }

    return 0;
}
