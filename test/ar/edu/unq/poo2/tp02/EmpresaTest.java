package ar.edu.unq.poo2.tp02;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;
import ar.edu.unq.poo2.tp02.enums.EMetodoDePago;

class EmpresaTest {
	private Empresa empresa;
	private Empleado johnDoe;
	private Empleado janeDoe;
	private Empleado jimDoe;
	
	@BeforeEach
	void setUp() throws Exception {
		johnDoe = new EmpleadoPermanente("John Doe", "123 Main St", LocalDate.of(1990, 1, 15), 100000.0, EEstadoCivil.CASADO, 2, 5);
		janeDoe = new EmpleadoTemporal("Jane Doe", "456 Elm St", LocalDate.of(1995, 6, 20), 80000.0, EEstadoCivil.SOLTERO, LocalDate.of(2025, 12, 31), 10);
		jimDoe = new EmpleadoContratado("Jim Doe","789 Oak St", LocalDate.of(1988, 11, 5), 90000.0, EEstadoCivil.CASADO, "CTR-12345", EMetodoDePago.TRANSFERENCIA);
		
		empresa = new Empresa("UNQ", "23-12345678-9");
		
		empresa.contratarEmpleado(johnDoe);
		empresa.contratarEmpleado(janeDoe);
		empresa.contratarEmpleado(jimDoe);
	}

	@Test
	void testTotalSueldosNeto() {
		assertEquals(229667.5d, empresa.netoTotal());
	}

	@Test
	void testLiquidarSueldos() {
		empresa.liquidarEmpleados();
		
		Set<ReciboDeHaberes> haberesJohn = johnDoe.getHaberes();
		Set<ReciboDeHaberes> haberesJane = janeDoe.getHaberes();
		Set<ReciboDeHaberes> haberesJim = jimDoe.getHaberes();
		
		assertFalse(haberesJohn.isEmpty());
		assertFalse(haberesJane.isEmpty());
		assertFalse(haberesJim.isEmpty());

		ReciboDeHaberes reciboJohn = haberesJohn.iterator().next();
		ReciboDeHaberes reciboJane = haberesJane.iterator().next();
		ReciboDeHaberes reciboJim = haberesJim.iterator().next();

		assertEquals(75447.5d, reciboJohn.getSueldoNeto());
		assertEquals(64270.0d, reciboJane.getSueldoNeto());
		assertEquals(89950.0d, reciboJim.getSueldoNeto());
	}
}
