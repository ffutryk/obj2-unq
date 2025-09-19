package ar.edu.unq.poo2.tp05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoCooperativaTest {
    private ProductoCooperativa productoCoop;

    @BeforeEach
    void setUp() {
        productoCoop = new ProductoCooperativa(100.0, 10);
    }

    @Test
    void montoDebeAplicarDescuentoIVA() {
        assertEquals(99.1d, productoCoop.monto());
    }
}