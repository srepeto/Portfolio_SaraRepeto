package cocina;

public class Pho extends Noodle {

    public Pho () {
        super("harina de arroz");
    }

    @Override
    public void elaboracion() {
        System.out.println("Hidrate los pho durante 1 hora, para luego cocerlos 1 minuto en caldo. Finalmente sazónelos con cilantro y jalapeños.");
    }

    @Override
    public void harina() {
        System.out.println("Básicamente hecho de "+harina+"\n");
    }
}
