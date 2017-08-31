#include <stdio.h>
#include <stdlib.h>
#define Maxx 200000

int a[Maxx];
int c[Maxx];

void merging(int low, int mid, int high) {
   int l1, l2, i;

   for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
      if(a[l1] <= a[l2])
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

int main()
{
    int n,m,d,t,y,i,x,found=1,count=0;
    long long sum=0;
    scanf("%d %d %d",&n,&m,&d);
    t=n*m;
    for(i=0;i<t;i++){
        scanf("%d",&a[i]);
        sum+=a[i];
    }
    x=sum/t;
    sort(0,t-1);
    y=t/2;
        i=1;
        while(y+i<t){
            while(a[y+i]>a[y]){
            a[y+i]-=d;
            count++;
            }
            if(a[y+i]!=a[y]){
                found=0;
                break;
            }
            i++;
        }
        i=1;
        while((y-i>=0)&&found){
            while(a[y-i]<a[y]){
            a[y-i]+=d;
            count++;
            }
            if(a[y-i]!=a[y]){
                found=0;
                break;
            }
            i++;
        }
        if(!found){
            printf("-1");
        }else{
        printf("%d",count);
        }

    return 0;
}
