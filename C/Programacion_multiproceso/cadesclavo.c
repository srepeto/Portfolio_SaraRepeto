#include <stdio.h>
#include "pvm3.h"
#include <stdlib.h>
#include <string.h>

main()
{
	char buf2[100];
	char buf[100];
	int i, parent_tid = pvm_parent();
	
	//SE RECIBEN LOS DATOS DEL MAESTRO
	pvm_recv(parent_tid, 1); 
	pvm_upkstr(buf);
	
	for(i = 0; i< strlen(buf) ; i++)
	{
		buf2[i] = toupper(buf[i]);
	}
		
	buf2[strlen(buf)]='\0';
	
	//SE ENVIA EL RESULTADO AL MAESTRO
	pvm_initsend(PvmDataDefault);
	pvm_pkstr(buf2);
	pvm_send(parent_tid, 2);
	
	pvm_exit();
	exit(0);
}
