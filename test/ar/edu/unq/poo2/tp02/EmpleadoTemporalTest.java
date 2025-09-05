package ar.edu.unq.poo2.tp02;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

class EmpleadoTemporalTest {
	private Empleado empleado;

	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoTemporal("Jane Doe", "456 Elm St", LocalDate.of(1995, 6, 20), 80000.0, EEstadoCivil.SOLTERO, LocalDate.of(2025, 12, 31), 10);
	}

	@Test
	void testSueldoBruto() {
		assertEquals(80400.0d, empleado.sueldoBruto());
	}

	@Test
	void testSueldoNeto() {
		assertEquals(64270.0d, empleado.sueldoNeto());
	}
	
	@Test
	void testRetenciones() {
		assertEquals(16130.0, empleado.retenciones());
	}
}
