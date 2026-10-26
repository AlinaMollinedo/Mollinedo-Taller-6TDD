package test;

import main.TresEnRaya;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TresEnRayaTestIA {
    private TresEnRaya juego;

    @BeforeEach
    void setUp() {
        juego = new TresEnRaya();
    }

    // ==========================================
    // REQUERIMIENTO 1: Colocar piezas en el tablero
    // ==========================================

    @Test
    void debeLanzarExcepcionCuandoXEstaFueraDelTablero() {
        assertThrows(Exception.class, () -> juego.jugar(4, 1));
    }

    @Test
    void debeLanzarExcepcionCuandoYEstaFueraDelTablero() {
        assertThrows(Exception.class, () -> juego.jugar(1, 4));
    }

    @Test
    void debeLanzarExcepcionCuandoLaPosicionEstaOcupada() throws Exception {
        juego.jugar(1, 1);

        assertThrows(Exception.class, () -> juego.jugar(1, 1));
    }

    // ==========================================
    // REQUERIMIENTO 2: Determinar el siguiente turno
    // ==========================================

    @Test
    void elPrimerTurnoDebeSerDeX() {
        assertEquals('X', juego.siguienteTurno());
    }

    @Test
    void despuesDeXDebeJugarMas() throws Exception {
        juego.jugar(1, 1);

        assertEquals('+', juego.siguienteTurno());
    }

    @Test
    void despuesDeMasDebeJugarX() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(2, 1); // +

        assertEquals('X', juego.siguienteTurno());
    }

    // ==========================================
    // REQUERIMIENTO 3: Comprobar la victoria
    // ==========================================

    @Test
    void noHayGanadorCuandoNoSeCompletaUnaLinea() throws Exception {
        assertEquals("No hay ganador", juego.jugar(1, 1));
        assertEquals("No hay ganador", juego.jugar(1, 2));
        assertEquals("No hay ganador", juego.jugar(2, 2));
    }

    @Test
    void XGanaCuandoCompletaUnaLineaHorizontal() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 1); // X
        juego.jugar(2, 2); // +

        String resultado = juego.jugar(3, 1); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    void XGanaCuandoCompletaUnaLineaVertical() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 1); // X
        juego.jugar(2, 2); // +

        String resultado = juego.jugar(3, 1); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    void XGanaCuandoCompletaLaDiagonalPrincipal() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 2); // X
        juego.jugar(1, 3); // +

        String resultado = juego.jugar(3, 3); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    void XGanaCuandoCompletaLaDiagonalSecundaria() throws Exception {
        juego.jugar(1, 3); // X
        juego.jugar(1, 1); // +
        juego.jugar(2, 2); // X
        juego.jugar(2, 1); // +

        String resultado = juego.jugar(3, 3); // X

        assertEquals("X es el ganador", resultado);
    }
}
