package act7;

public class Cuenta {
    float saldo;
    float valorMaximo;

    public Cuenta (float saldo, float valorMaximo) {
        this.saldo = saldo;
        this.valorMaximo = valorMaximo;
    }

    public float getSaldo() {
        return saldo;
    }

    public synchronized void ingreso(float cantidadSuma, String nombre) {
        float saldoSupuesto = getSaldo() + cantidadSuma;
        if (saldoSupuesto <= valorMaximo) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
            saldo += cantidadSuma;
            System.out.println(nombre + " ha ingresado " + cantidadSuma + "€");
            System.out.println("El saldo actual es de " + getSaldo() + "€");
        } else {
            System.out.println(nombre + " no ha podido ingresar " + cantidadSuma + "€ porque se superaría el saldo máximo\n");
        }
    }

    public synchronized void reintegro (float cantidadResta, String nombre) {
        if (getSaldo() >= cantidadResta) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
            saldo -= cantidadResta;
            System.out.println(nombre + " ha realizado un reintegro de " + cantidadResta + "€");
            System.out.println("El saldo actual es de " + getSaldo() + "€");
        } else {
            System.out.println(nombre + " no ha podido realizar el reintegro de " + cantidadResta +"€ porque no hay saldo suficiente\n");
        }
    }

}
