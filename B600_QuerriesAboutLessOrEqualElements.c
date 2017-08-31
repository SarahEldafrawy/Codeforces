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

int bin(int low,int high,int x){
    int mid;
    if(x>=a[low]){
    if(low<high){
        mid=(low+high)/2;
        if (a[mid]<=x && a[mid+1]>x){
            return mid;
        }else if(a[mid]<=x){
            return bin(mid+1,high,x);
        }else{
            return bin(low,mid,x);
        }
    }else if(low==high){
        return high;
    }
    }else{return -1;}

}

int main() {

    int i=0,n,m,y;
    scanf("%d %d",&n,&m);
    int b[m];
    for(i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    for(i=0;i<m;i++){
        scanf("%d",&b[i]);
    }
    sort(0,n-1);

    for(i=0;i<m;i++){
        y=bin(0,n-1,b[i]);
        b[i]=y+1;
    }
    for(i=0;i<m;i++){
        printf("%d ",b[i]);
    }

      return 0;
}
