#include <stdio.h>
#include "pvm3.h"
#include <stdlib.h>
//En este caso se lanzarán dos tareas, una en cada host.
main()
{
	int tareas, cc, tid[2], i;
	char buf[100];
	
	printf("Proceso maestro : t%x\n", pvm_mytid()); 
	tareas = pvm_spawn("hello_other", (char**)0, 0, "", 2, tid);
	printf("Numero de tareas lanzadas : %d \n", tareas);
	
	for(i = 0; i < tareas; i++)
	{
		cc = pvm_recv(tid[i], -1);
		pvm_upkstr(buf);
		printf("Mensaje de t%x : %s\n", tid[i], buf);
	}
	
	pvm_exit();
	exit(0);
}
