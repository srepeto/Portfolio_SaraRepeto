package app_movilidad;
import javax.swing.*;
import java.text.DecimalFormat;

public class MetodosMov {
    private float descJub=0.5f, descParado=0.6f, descDisc=0.75f, descEst=0.8f;
    int colectivo, numdias, numviajes;

    public MetodosMov (int colectivo, int numdias, int numviajes) {
        this.colectivo=colectivo;
        this.numdias=numdias;
        this.numviajes=numviajes;
    }

    public float billeteSimple () {
        float precSimple=2.75f, precioTotal, resultSimple=0;

        precioTotal = precSimple*numviajes;

        switch (colectivo) {
            case 1:
                resultSimple = precSimple;
                break;
            case 2:
                resultSimple = (precioTotal-(precioTotal*descJub))/numviajes;
                break;
            case 3:
                resultSimple = (precioTotal-(precioTotal*descDisc))/numviajes;
                break;
            case 4:
                resultSimple = (precioTotal-(precioTotal*descParado))/numviajes;
                break;
            case 5:
                resultSimple = (precioTotal-(precioTotal*descEst))/numviajes;
                break;
        }

        return resultSimple;

    }

    public float precioIlimitado7d () {

        int i, preciobono7=33;
        float precioTotal, numbonos7, result7d=0;

        for (i=1; i<99; i++) {
            if (numdias <= (7*i)) {
                break;
            }
        }
        numbonos7 = i;
        precioTotal = numbonos7*preciobono7;

        switch (colectivo) {
            case 1:
                result7d = precioTotal/numviajes;
                break;
            case 2:
                result7d = (precioTotal-(precioTotal*descJub))/numviajes;
                break;
            case 3:
                result7d = (precioTotal-(precioTotal*descDisc))/numviajes;
                break;
            case 4:
                result7d = (precioTotal-(precioTotal*descParado))/numviajes;
                break;
            case 5:
                result7d = (precioTotal-(precioTotal*descEst))/numviajes;
                break;
        }

        return result7d;

    }

    public float precioIlimitado30d () {

        int i, preciobono30=127;
        float precioTotal, numbonos30, result30d=0;

        for (i=1; i<99; i++) {
            if (numdias <= (30*i)) {
                break;
            }
        }
        numbonos30 = i;
        precioTotal = numbonos30*preciobono30;

        switch (colectivo) {
            case 1:
                result30d = precioTotal/numviajes;
                break;
            case 2:
                result30d = (precioTotal-(precioTotal*descJub))/numviajes;
                break;
            case 3:
                result30d = (precioTotal-(precioTotal*descDisc))/numviajes;
                break;
            case 4:
                result30d = (precioTotal-(precioTotal*descParado))/numviajes;
                break;
            case 5:
                result30d = (precioTotal-(precioTotal*descEst))/numviajes;
                break;
        }

        return result30d;

    }

    public String[] calculaPreciosViaje () {
        DecimalFormat formatDec = new DecimalFormat("#.##");
        String areatexto="", billeteFinal="";
        float precSimple = billeteSimple();
        float prec7d = precioIlimitado7d();
        float prec30d = precioIlimitado30d();
        float menor = Math.min(Math.min(precSimple,prec7d),Math.min(prec7d,prec30d));

        if (precSimple==menor) {
            areatexto="Debería coger la opción de Billete suelto ("+formatDec.format(menor)+"€/viaje)\n";
            billeteFinal="1";
        }

        if (prec7d==menor) {
            if (prec7d!=precSimple) {
                areatexto= "Debería coger la opción de Bono para 7 días ("+formatDec.format(menor)+"€/viaje)\n";
                billeteFinal="2";
            }
        }

        if (prec30d==menor) {
            if (prec30d!=precSimple && prec30d!=prec7d) {
                areatexto= "Debería coger la opción de Bono para 30 días ("+formatDec.format(menor)+"€/viaje)\n";
                billeteFinal="3";
            }
        }

        String [] devolver = {areatexto, billeteFinal};

        return devolver;
    }

}
