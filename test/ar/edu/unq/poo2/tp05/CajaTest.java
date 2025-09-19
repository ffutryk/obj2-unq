package ar.edu.unq.poo2.tp05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {
    private Caja caja;
    private Producto p1;
    private ProductoCooperativa p2;
    private FacturaTest.TestAgencia agencia;
    private FacturaServicio facturaServicio;
    private FacturaImpuesto facturaImpuesto;

    @BeforeEach
    void setUp() {
        caja = new Caja();
        p1 = new Producto(50.0, 5);
        p2 = new ProductoCooperativa(100.0, 3);

        agencia = new FacturaTest.TestAgencia();
        facturaServicio = new FacturaServicio(agencia, 30.0, 2);
        facturaImpuesto = new FacturaImpuesto(agencia, 20.0);
    }

    @Test
    void montoTotalDebeSumarMontosDisminuirStockYNotificarAgencias() {
        double total = caja.montoTotal(List.of(p1, p2, facturaServicio, facturaImpuesto));

        assertEquals(50 + 99.1 + 60 + 20, total);

        assertEquals(4, p1.getStock());
        assertEquals(2, p2.getStock());

        assertTrue(agencia.contieneA(facturaServicio));
        assertTrue(agencia.contieneA(facturaImpuesto));
    }
}
