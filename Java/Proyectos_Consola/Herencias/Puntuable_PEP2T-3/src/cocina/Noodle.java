package cocina;

public class Noodle {
    int longitud, anchura;
    String forma, textura, harina;

    public Noodle (String harina) {
        this.harina=harina;
    }

    public void elaboracion() {
    }

    public void harina() {
    }

    public static void main (String[] args) {
        Spaghettis Spa = new Spaghettis();
        Ramen Ram = new Ramen();
        Pho Ph = new Pho();
        Noodle[] pastas = {Spa, Ram, Ph};

        for (Noodle comida: pastas) {
            comida.elaboracion();
            comida.harina();
        }

        /*for (int x=0; x<pastas.length; x++){
            pastas[x].Elaboracion();
            pastas[x].Harina();
        }*/

    }
}
