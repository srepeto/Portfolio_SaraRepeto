package PROG2T.PEP2T_2;

public class DigiIban {

    // Cuenta de ejemplo: ES85 2098 0008 64 1207383832

    public String generaIBAN (String digTotal){
        int m = 0;
        int fdigIBAN;
        String fdigitosIBAN;
        for (int i = 0; i < digTotal.length(); ++i) {
            m = (m * 10 + Integer.parseInt(String.valueOf(digTotal.charAt(i)))) % 97;
        }
        fdigIBAN = 98-m;

        if ((fdigIBAN>=0) && (fdigIBAN<=9)) {
            fdigitosIBAN = "0"+Integer.toString(fdigIBAN);
        } else {
            fdigitosIBAN = Integer.toString(fdigIBAN);
        }

        return fdigitosIBAN;
    }

    public void validacionIBAN (String digitosIBAN, String fdigitosIBAN) {
        if (fdigitosIBAN.equals(digitosIBAN.substring(2, 4))) {
            System.out.print("Dígitos calculados: ES" + fdigitosIBAN + "\tVerificación: Correcta\n");
        } else {
            System.out.print("Dígitos calculados: ES" + fdigitosIBAN + "\tVerificación: Incorrecta\n");
        }
    }

}
