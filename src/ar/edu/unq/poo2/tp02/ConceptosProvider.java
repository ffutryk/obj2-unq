package ar.edu.unq.poo2.tp02;

import java.util.HashSet;
import java.util.Set;

public abstract class ConceptosProvider {
	public abstract Set<Concepto> bonos(Empleado e);
	public abstract Set<Concepto> retenciones(Empleado e);
	
	protected void validarEmpleadoEsInstanciaDe(Empleado e, Class<? extends Empleado> clase) {
	    if (!clase.isInstance(e)) {
	        throw new IllegalArgumentException("Tipo de empleado inválido. Se esperaba: " + clase.getSimpleName());
	    }
	}
	
	public Set<Concepto> conceptos(Empleado e) {
		Set<Concepto> conceptos = new HashSet<Concepto>();
		
		conceptos.add(new Concepto("Sueldo Básico", e.getSueldoBasico()));
		conceptos.addAll(bonos(e));
		conceptos.addAll(retenciones(e));
		
		return conceptos;
	}
}
