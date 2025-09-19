package ar.edu.unq.poo2.tp05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {
    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto(100.0, 10);
    }

    @Test
    void montoDebeDevolverElPrecio() {
        assertEquals(100.0, producto.monto(), 0.0001);
    }

    @Test
    void alSerPagadoDisminuyeElStock() {
        int stockInicial = producto.getStock();
        producto.alSerPagado();
        assertEquals(stockInicial - 1, producto.getStock());
    }
}
