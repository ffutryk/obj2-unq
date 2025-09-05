package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

public class EmpleadoTemporal extends Empleado {
	private LocalDate finDesignacion;
	private int horasExtra;
	
	public EmpleadoTemporal(String nombre, String direccion, LocalDate fechaNacimiento, double sueldoBasico, EEstadoCivil estado, LocalDate finDesignacion, int horasExtra) {
		super(nombre, direccion, fechaNacimiento, sueldoBasico, estado, ConceptosTemporalProvider.getInstance());
		this.finDesignacion = finDesignacion;
		this.horasExtra = horasExtra;
	}

	public LocalDate getFinDesignacion() {
		return finDesignacion;
	}

	public int getHorasExtra() {
		return horasExtra;
	}
}
