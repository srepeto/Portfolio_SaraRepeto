package controlador;

import modelo.Cuenta;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificaCuentasTest {

    ModificaCuentas mc = new ModificaCuentas();

    private static Object[][] valoresAinsertar() {
        Cuenta cuenta1 = new Cuenta(998, "Paco", "2020-12-04", "España", 1600);
        Cuenta cuenta2 = new Cuenta(999, "María", "2020-12-10", "Argentina", 1300);
        return new Object [][] {
                {true, cuenta1}, {true, cuenta2}
        };
    }

    @ParameterizedTest(name = "Inserción {index}")
    @MethodSource("valoresAinsertar")

    public void testInsertar (boolean esperada, Cuenta entrada) {
        assertEquals(esperada, mc.insertarCuenta(entrada));
    }

}
