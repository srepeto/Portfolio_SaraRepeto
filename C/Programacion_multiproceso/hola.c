#include <stdio.h>
#include <pvm3.h>
int main()
{
int mytid;
mytid = pvm_mytid();
printf("Mi TID es %x\n", mytid); pvm_exit();
return 0;
}