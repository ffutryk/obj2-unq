package ar.edu.unq.poo2.tp02;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;
import ar.edu.unq.poo2.tp02.enums.EMetodoDePago;

class EmpleadoContratadoTest {
	private Empleado empleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoContratado("Jim Doe","789 Oak St", LocalDate.of(1988, 11, 5), 90000.0, EEstadoCivil.CASADO, "CTR-12345", EMetodoDePago.TRANSFERENCIA);
	}

	@Test
	void testSueldoBruto() {
		assertEquals(90000.0d, empleado.sueldoBruto());
	}

	@Test
	void testSueldoNeto() {
		assertEquals(89950.0d, empleado.sueldoNeto());
	}
	
	@Test
	void testRetenciones() {
		assertEquals(50.0d, empleado.retenciones());
	}
}
