package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;
import ar.edu.unq.poo2.tp02.enums.EMetodoDePago;

public class EmpleadoContratado extends Empleado {
	private String nroContrato;
	private EMetodoDePago metodoDePago;
	
	public EmpleadoContratado(String nombre, String direccion, LocalDate fechaNacimiento, double sueldoBasico, EEstadoCivil estado, String nroContrato, EMetodoDePago metodoDePago) {
		super(nombre, direccion, fechaNacimiento, sueldoBasico, estado, ConceptosContratadoProvider.getInstance());
		this.nroContrato = nroContrato;
		this.metodoDePago = metodoDePago;
	}
}
