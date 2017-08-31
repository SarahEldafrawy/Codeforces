#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    char str[100000];
    gets(str);
    int i=0,j=0,found=0;
    while(str[i]!='\0'){
        if(str[i]=='0'){
            found=1;
            str[i]=2;
            break;
        }
        i++;
    }
    if(!found){str[i-1]='\0';}
   while(str[j]!='\0'){
        if(str[j]==2){j++;continue;}
        printf("%c",str[j]);
        j++;
   }

    return 0;
}
