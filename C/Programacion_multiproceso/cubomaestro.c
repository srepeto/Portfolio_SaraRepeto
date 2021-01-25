#include <stdlib.h>
#include <stdio.h>
#include <pvm3.h>

int main()
{
	int tarea, tid, cc, result;
	int etqenvio = 1;
	int etqrecibe = 2;
	int num = 3;
	
	tarea = pvm_spawn("cuboesclavo", (char **) 0, 0, "", 1, &tid);
	
	//ENVIAMOS MENSAJE
	pvm_initsend(PvmDataDefault);
	pvm_pkint(&num, 1, 1);
	pvm_send(tid, etqenvio);
	
	//RECIBIMOS MENSAJE
	cc = pvm_recv(tid, etqrecibe);
	pvm_upkint(&result, 1, 1);
	printf("El cubo de %d es: %d", num, result);
	
	pvm_exit();
	exit(0);
}
