package ar.edu.unq.poo2.tp02;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Empresa {
	private String nombre;
	private String cuit;
	private Set<Empleado> empleados;
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = new HashSet<Empleado>();
	}
	
	public Empresa(String nombre, String cuit, Set<Empleado> empleados) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = empleados;
	}
	
	public double brutoTotal() {
		return empleados.stream().mapToDouble(Empleado::sueldoBruto).sum();
	}

	public double retencionesTotal() {
		return empleados.stream().mapToDouble(Empleado::retenciones).sum();
	}
	
	public double netoTotal() {
		return empleados.stream().mapToDouble(Empleado::sueldoNeto).sum();
	}
	
	public void liquidarEmpleados() {
		for(Empleado e : empleados) {
			ReciboDeHaberes recibo = liquidarEmpleado(e);
			
			e.agregarRecibo(recibo);
		}
	}
	
	public void contratarEmpleado(Empleado e) {
		empleados.add(e);
	}
	
	private ReciboDeHaberes liquidarEmpleado(Empleado e) {
		double bruto = e.sueldoBruto();
		double neto = e.sueldoNeto();
		Set<Concepto> conceptos = e.conceptos();
		LocalDate hoy = LocalDate.now();
		
		ReciboDeHaberes recibo = new ReciboDeHaberes(e.getNombre(), e.getDireccion(), hoy, bruto, neto, conceptos);
		
		return recibo;
	}
}
