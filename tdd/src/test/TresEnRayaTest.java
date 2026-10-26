package test;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.TresEnRaya;

public class TresEnRayaTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TresEnRaya tresEnRaya;

    // Requerimiento 1
    @Test
    public void siFueraXLanzarExcepcion() throws Exception {
        tresEnRaya = new TresEnRaya();

        exception.expect(Exception.class);
        tresEnRaya.jugar(6, 2);
    }

    @Test
    public void siFueraYLanzarExcepcion() throws Exception {
        tresEnRaya = new TresEnRaya();

        exception.expect(Exception.class);
        tresEnRaya.jugar(2, 6);
    }

    @Test
    public void siOcupadoLanzarExcepcion() throws Exception {
        tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar(1, 3);

        exception.expect(Exception.class);
        tresEnRaya.jugar(1, 3);
    }

    // Requerimiento 2

    @Test
    public void primerTurnoEsX() {
        tresEnRaya = new TresEnRaya();

        assertEquals('X', tresEnRaya.siguienteTurno());
    }

    @Test
    public void siUltimoXEntoncesMas() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // Ultimo X
        assertEquals('+', tresEnRaya.siguienteTurno());

        tresEnRaya.jugar(1, 2); // Ultimo +
        assertEquals('X', tresEnRaya.siguienteTurno());

    }

    // Requerimiento 3

    @Test
    public void siNoHayGanador() throws Exception {
        tresEnRaya = new TresEnRaya();

        assertEquals("No hay ganador", tresEnRaya.jugar(1, 1));
    }

    @Test
    public void siHayGanadorHorizontal() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // X
        tresEnRaya.jugar(3, 3); // +
        tresEnRaya.jugar(2, 1); // X
        tresEnRaya.jugar(3, 2); // +
        assertEquals("X es el ganador", tresEnRaya.jugar(3, 1));
    }

    @Test
    public void siHayGanadorVertical() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // X
        tresEnRaya.jugar(3, 3); // +
        tresEnRaya.jugar(1, 2); // X
        tresEnRaya.jugar(3, 2); // +
        assertEquals("X es el ganador", tresEnRaya.jugar(1, 3));
    }

    @Test
    public void siHayGanadorDiagonal() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 1); // X
        tresEnRaya.jugar(1, 2); // +
        tresEnRaya.jugar(2, 2); // X
        tresEnRaya.jugar(1, 3); // +
        assertEquals("X es el ganador", tresEnRaya.jugar(3, 3));
    }

    @Test
    public void siHayGanadorDiagonalOpuesta() throws Exception {
        tresEnRaya = new TresEnRaya();

        tresEnRaya.jugar(1, 3); // X
        tresEnRaya.jugar(1, 2); // +
        tresEnRaya.jugar(2, 2); // X
        tresEnRaya.jugar(2, 3); // +
        assertEquals("X es el ganador", tresEnRaya.jugar(3, 1));
    }
}
