#include <stdlib.h>
#include <stdio.h>
#include <pvm3.h>

int main()
{
	int ptid, cubo;
	int numrecibido;
	
	ptid = pvm_parent();
	
	//RECIBIMOS MENSAJE
	pvm_recv(ptid, 1);
	pvm_upkint(&numrecibido, 1, 1);
	
	//OPERAMOS
	cubo = numrecibido * numrecibido * numrecibido;
	
	//ENVIAMOS MENSAJE
	pvm_initsend(PvmDataDefault);
	pvm_pkint(&cubo, 1, 1);
	pvm_send(ptid, 2);
	
	pvm_exit();
	exit(0);
}
