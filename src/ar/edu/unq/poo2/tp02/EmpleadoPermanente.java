package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

public class EmpleadoPermanente extends Empleado {
	private int cantHijos;
	private int antiguedad;
	
	public EmpleadoPermanente(String nombre, String direccion, LocalDate fechaNacimiento, double sueldoBasico, EEstadoCivil estado, int cantHijos, int antiguedad) {
		super(nombre, direccion, fechaNacimiento, sueldoBasico, estado, ConceptosPermanenteProvider.getInstance());
		this.cantHijos = cantHijos;
		this.antiguedad = antiguedad;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public int getAntiguedad() {
		return antiguedad;
	}
}
