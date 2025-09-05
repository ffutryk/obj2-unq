package ar.edu.unq.poo2.tp02;

import java.util.HashSet;
import java.util.Set;

public class ConceptosContratadoProvider extends ConceptosProvider {
	private static ConceptosContratadoProvider instance;
	
    private static final double GASTOS_ADMINISTRATIVOS_CONTRACTUALES = 50.0;
	
	@Override
	public Set<Concepto> bonos(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoContratado.class);
		
		EmpleadoContratado empleado = (EmpleadoContratado) e;
		Set<Concepto> bonos = new HashSet<Concepto>();

		// Un empleado contratado no cuenta con bonos de momento.
		
		return bonos;
	}

	@Override
	public Set<Concepto> retenciones(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoContratado.class);
		
		EmpleadoContratado empleado = (EmpleadoContratado) e;
		Set<Concepto> retenciones = new HashSet<Concepto>();

		retenciones.add(retencionGastosAdministrativos());
		
		return retenciones;
	}
	
	private Concepto retencionGastosAdministrativos() {
		return new Concepto("Gastos Administrativos Contractuales", GASTOS_ADMINISTRATIVOS_CONTRACTUALES);
	}
	
	public static ConceptosContratadoProvider getInstance() {
        if (instance == null) {
            instance = new ConceptosContratadoProvider();
        }
        
        return instance;
	}
}
