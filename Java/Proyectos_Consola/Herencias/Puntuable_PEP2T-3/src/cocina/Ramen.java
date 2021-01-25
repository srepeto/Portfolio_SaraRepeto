package cocina;

public class Ramen extends Noodle {

    public Ramen () {
        super("harina de trigo");
    }

    @Override
    public void elaboracion() {
        System.out.println("Cueza el ramen 5 minutos en caldo, añada la carne, los champiñones, el huevo y las verduras.");
    }

    @Override
    public void harina() {
        System.out.println("Básicamente hecho de "+harina+"\n");
    }
}
