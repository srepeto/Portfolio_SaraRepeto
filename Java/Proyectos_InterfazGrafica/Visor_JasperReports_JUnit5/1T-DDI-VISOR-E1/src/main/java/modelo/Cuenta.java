package modelo;

public class Cuenta {

    private int numCuenta;
    private String titular;
    private String fechaApertura;
    private String nac;
    private double saldo;

    public Cuenta () {
        numCuenta = 0;
        titular = "";
        fechaApertura = "";
        nac = "";
        saldo = 0;
    }

    public Cuenta(int numCuenta, String titular, String fechaApertura, String nac, double saldo) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.nac = nac;
        this.saldo = saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getNac() {
        return nac;
    }

    public void setNac(String nac) {
        this.nac = nac;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
