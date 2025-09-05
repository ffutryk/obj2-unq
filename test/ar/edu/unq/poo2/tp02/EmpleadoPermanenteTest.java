package ar.edu.unq.poo2.tp02;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

class EmpleadoPermanenteTest {
	private Empleado empleado;
	
	@BeforeEach
	void setUp() throws Exception {
		empleado = new EmpleadoPermanente("John Doe", "123 Main St", LocalDate.of(1990, 1, 15), 100000.0, EEstadoCivil.CASADO, 2, 5);
	}

	@Test
	void testSueldoBruto() {
		assertEquals(100650.0d, empleado.sueldoBruto());
	}

	@Test
	void testSueldoNeto() {
		assertEquals(75447.5d, empleado.sueldoNeto());
	}
	
	@Test
	void testRetenciones() {
		assertEquals(25202.5d, empleado.retenciones());
	}
}
