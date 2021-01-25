package cocina;

public class Spaghettis extends Noodle {

    public Spaghettis () {
        super("harina de sémola");
    }

    @Override
    public void elaboracion() {
        System.out.println("Cueza los spaghettis de 8 a 10 minutos y añada la salsa al gusto, queso o aceite y ajo.");
    }

    @Override
    public void harina() {
        System.out.println("Básicamente hecho de "+harina+"\n");
    }
}
