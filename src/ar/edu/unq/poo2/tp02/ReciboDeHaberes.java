package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;


public final class ReciboDeHaberes {
	private final String nombreEmpleado;
	private final String direccion;
	private final LocalDate fechaEmision;
	private final double sueldoBruto;
	private final double sueldoNeto;
	private final Set<Concepto> conceptos;
	
	public ReciboDeHaberes(String nombreEmpleado, String direccion, LocalDate fechaEmision, double sueldoBruto, double sueldoNeto, Set<Concepto> conceptos) {
		this.nombreEmpleado = nombreEmpleado;
		this.direccion = direccion;
		this.fechaEmision = fechaEmision;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.conceptos = Collections.unmodifiableSet(conceptos);
	}

	public double getSueldoNeto() {
		return sueldoNeto;
	}
}
