package ar.edu.unq.poo2.tp05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacturaTest {
    private TestAgencia agencia;

    @BeforeEach
    void setUp() {
        agencia = new TestAgencia();
    }

    @Test
    void facturaImpuestoMontoDebeSerTasaDeServicio() {
        FacturaImpuesto factura = new FacturaImpuesto(agencia, 200.0);
        assertEquals(200.0, factura.monto(), 0.0001);
    }

    @Test
    void facturaServicioMontoDebeMultiplicarCostoYCantidad() {
        FacturaServicio factura = new FacturaServicio(agencia, 30.0, 5);
        assertEquals(150.0, factura.monto(), 0.0001);
    }

    @Test
    void alSerPagadoNotificaAlaAgencia() {
        FacturaServicio factura = new FacturaServicio(agencia, 10.0, 1);
        factura.alSerPagado();

        assertTrue(agencia.contieneA(factura));
    }

    static class TestAgencia implements Agencia {
        private List<Factura> facturas = new ArrayList<>();

        @Override
        public void registrarPago(Factura factura) {
        	facturas.add(factura);
        }
        
        public boolean contieneA(Factura factura) {
        	return facturas.contains(factura);
        }
    }
}