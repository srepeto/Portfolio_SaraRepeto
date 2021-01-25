#include <stdio.h> 
#include "pvm3.h" 
#include <stdlib.h>
#include <string.h> 

main()
{
	int tareas, cc, tid;
	char buf[100];
	int etqenvio = 1;
	int etqrecibe = 2;
	
	strcpy(buf, "mensaje en minúscula");
	tareas = pvm_spawn("cadesclavo", (char**)0, 0, "", 1, &tid);
	
	//ENVIO CADENA
	pvm_initsend(PvmDataDefault);
	pvm_pkstr(buf);
	pvm_send(tid, etqenvio);
	printf("\tENVÍO A t%x: %s\n", tid, buf);
	
	//RECIBO CADENA
	cc = pvm_recv(tid, etqrecibe);
	pvm_upkstr(buf);
	printf("\tRECIBO DE t%x: %s\n", tid, buf);
	
	pvm_exit();
	exit(0);
}
