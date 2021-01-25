#include <stdio.h>
#include <stdlib.h>
#include <pvm3.h>

int main()
{
	int tabla[10];
	int tresult[2];
	int tareas, cc, tid[2], i, sum = 0;
	int etqenvio = 1, etqrecibe = 2;
	
	
	printf("Proceso maestro : t%x\n", pvm_mytid());
	
	//SE LLENA LA TABLA CON NÚMEROS
	for(i = 0; i < 10; i++) 
	{
		tabla[i] = i;
	}
	
	//SE CREAN LOS ESCLAVOS
	tareas = pvm_spawn("sumesclavo", (char**)0, 0, "", 2, tid);
	printf("Tareas : %d\n", tareas);
	
	//SE ENVIAN LOS DATOS
	for(i = 0; i < 2; i++) 
	{ 
		pvm_initsend(PvmDataDefault);
		pvm_pkint(tabla + i*5, 5, 1);
		pvm_send(tid[i], etqenvio);
	}
	
	//SE RECIBEN LOS DATOS
	for(i = 0; i < 2; i++) 
	{
		cc = pvm_recv(tid[i], etqrecibe);
		pvm_upkint(tresult + i, 1, 1);
		printf("- RECIBO DE t%x : %d\n", tid[i], tresult[i]);
	}
	
	//SE OBTIENE LA SUMA
	for(i = 0; i < 2; i++)
	{
		sum = sum + tresult[i];
	}
	
	printf("LA SUMA ES = %d\n", sum);
	
	pvm_exit();
	exit(0);
}
