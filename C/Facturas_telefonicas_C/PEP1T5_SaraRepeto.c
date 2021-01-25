#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
#include <conio.h>

typedef struct midato
{
	int num_abo;
	char nombre[30];
	float valor_fact;
}registro;

void opcion1(FILE *pfich)
{
	registro reg, *bufreg;
	bufreg = &reg;
	int bytesreg = sizeof(reg);

	printf ("\nAlta de factura\n");
	printf ("\nNúmero del abonado: ");
	scanf ("%d", &reg.num_abo);
	fflush(stdin);

	printf ("\nNombre: ");
	gets(reg.nombre);
	
	printf ("\nValor de la factura: ");
	scanf ("%f", &reg.valor_fact);
	fflush(stdin);
	
	fwrite (bufreg,bytesreg,1,pfich);
	printf ("\n\tDatos incorporados al fichero\n");	
}

int opcion2(FILE *pfich)
{
	registro reg, *bufreg;
	bufreg = &reg;
	int numero;
	int bytesreg = sizeof(reg);
	printf ("\nModificación del valor de factura\n");
	printf ("\nNúmero del abonado: ");
	scanf ("%d", &numero);
	fflush(stdin);
	while (! feof(pfich))
	{
		fread(bufreg,bytesreg,1,pfich);
		if (numero==reg.num_abo)
		{
			fseek(pfich,-bytesreg,SEEK_CUR);
			printf ("\n\tValor de la factura: %f\n", reg.valor_fact);
			printf ("\nNuevo valor de factura: ");
			scanf ("%f", &reg.valor_fact);
			fflush(stdin);
			fwrite (bufreg,bytesreg,1,pfich);
			printf ("\nDato modificado en el fichero");
			return 0;
		}	
	}
	printf ("\nAbonado no registrado\n");	
	return 0;
}

int opcion3(FILE *pfich)
{
	registro reg, *bufreg;
	bufreg = &reg;
	int numero;
	int bytesreg = sizeof(reg);
	
	printf ("\nNúmero del abonado: ");
	scanf ("%d", &numero);
	fflush(stdin);
	while (! feof(pfich))
	{
		fread(bufreg,bytesreg,1,pfich);
		if (numero==reg.num_abo)
		{
			printf ("\n\tValor de la factura: %f\n", reg.valor_fact);
			return 0;
		}	
	}
	printf ("\nAbonado no registrado\n");
}

void opcion4(FILE *pfich)
{
	registro reg, *bufreg;
	bufreg = &reg;
	float factotal=0;
	int bytesreg = sizeof(reg);
	printf("\nConsulta facturación total\n");
	while (! feof(pfich))
	{
		fread(bufreg,bytesreg,1,pfich);
		if (! feof(pfich))
		{
			factotal = factotal + reg.valor_fact;
		}
		else 
		{
			break;
		}
	}
	printf ("\nFacturación total: %f\n", factotal);
}

int main()
{
	setlocale(LC_CTYPE, "Spanish");
	FILE *pfich;
	int opcion;
	struct midato TAB;
	printf ("PROGRAMA GESTIÓN COMPAÑÍA TELEFÓNICA");
	do
	{
		printf ("\n\nMenú de opciones\n\n1) Alta de nuevas facturas\n2) Modificación del valor de factura\n3) Consulta del dato de facturación de un abonado\n4) Consulta del dato de facturación total de la compañía\n5) Eliminar el fichero\n6) Salir\n\n\n");
		printf ("Opción: ");
		scanf("%d", &opcion);
		fflush (stdin);

		switch (opcion)
		{
			case 1:
				pfich = fopen("facturas_telf.dat", "a");
				if (pfich == NULL)
				{
					printf("No ha sido posible abrir el fichero");
					exit(1);
				}
				opcion1 (pfich);
				fclose (pfich);
				break;
			case 2:
				pfich = fopen("facturas_telf.dat", "r+b");
				if (pfich == NULL)
				{
					printf("No ha sido posible abrir el fichero");
					exit(1);
				}
				opcion2(pfich);
				fclose (pfich);
				break;		
			case 3:
				pfich = fopen("facturas_telf.dat", "r");
				if (pfich == NULL)
				{
					printf("No ha sido posible abrir el fichero");
					exit(1);
				}
				opcion3 (pfich);
				fclose (pfich);
				break;	
			case 4:
				pfich = fopen("facturas_telf.dat", "r");
				if (pfich == NULL)
				{
					printf("No ha sido posible abrir el fichero");
					exit(1);
				}
				opcion4(pfich);
				fclose (pfich);
				break;
			case 5:
				printf ("\nEliminar fichero\n");
				remove ("facturas_telf.dat");
				printf ("\n\tFichero eliminado\n");
				break;
		}
	}
	while(opcion!=6);{
	}
	return 0;
}
