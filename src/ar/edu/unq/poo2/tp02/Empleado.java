package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

public abstract class Empleado {
	private String nombre;
	private String direccion;
	private final LocalDate fechaNacimiento;
	private double sueldoBasico;
	private EEstadoCivil estado;
	private final ConceptosProvider conceptosProvider;
	private Set<ReciboDeHaberes> haberes = new HashSet<ReciboDeHaberes>();
	
	public Empleado(String nombre, String direccion, LocalDate fechaNacimiento, double sueldoBasico, EEstadoCivil estado, ConceptosProvider conceptosProvider) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.estado = estado;
		this.conceptosProvider = conceptosProvider;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	public EEstadoCivil getEstado() {
		return estado;
	}
	
	public Set<ReciboDeHaberes> getHaberes() {
		return Collections.unmodifiableSet(haberes);
	}
	
	public int edad() {
		LocalDate hoy = LocalDate.now();
		return Period.between(hoy, fechaNacimiento).getYears();
	}

	public Set<Concepto> conceptos() {
		return conceptosProvider.conceptos(this);
	}
	
	public double sueldoBruto() {
		Set<Concepto> bonos = conceptosProvider.bonos(this);
		
		return sueldoBasico + bonos.stream().mapToDouble(Concepto::getMonto).sum();
	}
	
	public double retenciones() {
		Set<Concepto> retenciones = conceptosProvider.retenciones(this);
		return retenciones.stream().mapToDouble(Concepto::getMonto).sum();
	}
	
	public double sueldoNeto() {
		return sueldoBruto() - retenciones();
	}
	
	public void agregarRecibo(ReciboDeHaberes recibo) {
		haberes.add(recibo);
	}
	
}
