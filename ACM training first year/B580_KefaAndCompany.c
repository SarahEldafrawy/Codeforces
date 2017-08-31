#include <stdio.h>
#include <stdlib.h>
#define Maxx 200000

    typedef struct{
        long long money;
        long long fren_s;
    }data;

    data a[Maxx];
    data c[Maxx];

void merging(int low, int mid, int high) {
   int l1, l2, i;

   for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
      if(a[l1].money <= a[l2].money)
         c[i] = a[l1++];

      else
         c[i] = a[l2++];
   }

   while(l1 <= mid)
      c[i++] = a[l1++];

   while(l2 <= high)
      c[i++] = a[l2++];

   for(i = low; i <= high; i++)
      a[i] = c[i];
}

void sort(int low, int high) {

   int mid;
   if(low < high) {
      mid = (low + high) / 2;
      sort(low, mid);
      sort(mid+1, high);
      merging(low, mid, high);
   } else {
      return;
   }
}

long long max(long long a,long long b){

    if(a-b>=0){
        return a;
    }else{
        return b;
    }

}

int main()
{

    long long n,d,i,fac=0,j;

    scanf("%lld %lld",&n,&d);

    long long sum[n+1];

    for(i=0;i<n;i++){
       scanf("%lld %lld",&a[i].money,&a[i].fren_s);
    }
    sum[0]=0;
    sort(0,n-1);
    for(i=1;i<=n;i++){
        sum[i]=sum[i-1]+a[i-1].fren_s;
    }
    j=1;
    for(i=0;i<n;i++){
        while((j<n) && (a[i].money+d>a[j].money)){
            j++;
        }
        fac=max(fac,sum[j]-sum[i]);
    }

    printf("%lld",fac);

    return 0;
}
