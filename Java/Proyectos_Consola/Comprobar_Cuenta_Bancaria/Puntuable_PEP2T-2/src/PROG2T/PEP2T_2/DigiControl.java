package PROG2T.PEP2T_2;

public class DigiControl {

    // Cuenta de ejemplo: ES85 2098 0008 64 1207383832

    public String generarDC(String digBanco, String digSucursal, String digCuenta) {

        String fdigControl;
        int digCont1=0, digCont2=0, x, y=0;
        int[] constantes = {1,2,4,8,5,10,9,7,3,6};

        // Calculamos el primer dígito de control

        for (x=2; x<=5; x++) {
            digCont1= digCont1 + constantes[x] * (Integer.parseInt(String.valueOf(digBanco.charAt(y))));
            y++;
        }

        y=0;
        for (x=6; x<constantes.length; x++) {
            digCont1= digCont1 + constantes[x] * (Integer.parseInt(String.valueOf(digSucursal.charAt(y))));
            y++;
        }
        digCont1 = 11-(digCont1%11);

        if (digCont1 == 10) {
            digCont1 = 1;
        } else if (digCont1 == 11){
            digCont1 = 0;
        }

        // Calculamos el segundo dígito de control

        y=0;
        for (x=0; x<constantes.length; x++) {
            digCont2= digCont2 + constantes[x] * (Integer.parseInt(String.valueOf(digCuenta.charAt(y))));
            y++;
        }
        digCont2 = 11-(digCont2%11);

        if (digCont2 == 10) {
            digCont2 = 1;
        } else if (digCont2 == 11){
            digCont2 = 0;
        }

        // Finalmente obtenemos los dos dígitos de control como cadena

        fdigControl = Integer.toString(digCont1) + Integer.toString(digCont2);

        return fdigControl;

    }

    public void validacion(String digBanco, String digSucursal, String digControl, String digCuenta, String fdigControl) {
        if (digControl.equals(fdigControl)) {
            System.out.print("Dígitos calculados: "+fdigControl+"\t   Verificación: Correcta\n");
        } else {
            System.out.print("Dígitos calculados: "+fdigControl+"\t   Verificación: Incorrecta\n");
        }
    }

}
