package act7;

public class Test {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100, 500);
        Persona p1 = new Persona ("Laura", cuenta);
        Persona p2 = new Persona ("Diego", cuenta);
        Persona p3 = new Persona ("Pedro", cuenta);

        p1.start();
        p2.start();
        p3.start();
    }

}
