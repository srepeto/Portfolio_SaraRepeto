#include <stdlib.h>
#include <stdio.h>
#include <pvm3.h>

int main()
{
	int mytid, parent_tid;
	int tabla[5];
	int sum = 0, i;
	
	
	mytid = pvm_mytid();
	parent_tid = pvm_parent();
	
	//SE RECIBEN LOS DATOS DEL MAESTRO
	pvm_recv(parent_tid, 1);
	pvm_upkint(tabla, 5, 1);
	
	//SE CALCULA LA SUMA
	for(i = 0; i < 5; i++)
	{
		sum = sum + tabla[i];
	}
	
	//SE ENVIA EL RESULTADO AL MAESTRO
	pvm_initsend(PvmDataDefault);
	pvm_pkint(&sum, 1, 1);
	printf("\tEsclavo : t%x Suma = %d ", mytid, sum);
	pvm_send(parent_tid, 2);
	
	pvm_exit();
	exit(0);
}
