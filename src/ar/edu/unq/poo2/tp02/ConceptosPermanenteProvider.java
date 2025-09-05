package ar.edu.unq.poo2.tp02;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unq.poo2.tp02.enums.EEstadoCivil;

public class ConceptosPermanenteProvider extends ConceptosProvider {
	private static ConceptosPermanenteProvider instance;
	
    private static final double BONO_POR_HIJO = 150.0;
    private static final double BONO_POR_CONYUGE = 100.0;
    private static final double BONO_POR_ANIO_ANTIGUEDAD = 50.0;
    private static final double PORCENTAJE_OBRA_SOCIAL = 0.10;
    private static final double MONTO_OBRA_SOCIAL_POR_HIJO = 20.0;
    private static final double PORCENTAJE_APORTES_JUBILATORIOS = 0.15;
	
	@Override
	public Set<Concepto> bonos(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoPermanente.class);
		
		EmpleadoPermanente empleado = (EmpleadoPermanente) e;
		Set<Concepto> bonos = new HashSet<Concepto>();
		
		bonos.add(bonoHijos(empleado.getCantHijos()));
		
		if (empleado.getEstado() == EEstadoCivil.CASADO) 
			bonos.add(bonoConyuge());
			
		bonos.add(bonoAntiguedad(empleado.getAntiguedad()));
		
		return bonos;
	}

	@Override
	public Set<Concepto> retenciones(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoPermanente.class);
		
		EmpleadoPermanente empleado = (EmpleadoPermanente) e;
		Set<Concepto> retenciones = new HashSet<Concepto>();
		
		double brutoEmpleado = empleado.sueldoBruto();
		
		retenciones.add(retencionObraSocial(brutoEmpleado, empleado.getCantHijos()));
		retenciones.add(retencionAportesJubilatorios(brutoEmpleado));
		
		return retenciones;
	}
	
	private Concepto bonoHijos(int cantHijos) {
		return new Concepto("Asignación por hijo", cantHijos * BONO_POR_HIJO);
	}
	
	private Concepto bonoConyuge() {
		return new Concepto("Asignación por cónyuge", BONO_POR_CONYUGE);
	}
	
	private Concepto bonoAntiguedad(int anios) {
		return new Concepto("Antigüedad", anios * BONO_POR_ANIO_ANTIGUEDAD);
	}
	
	private Concepto retencionObraSocial(double sueldoBruto, int cantHijos) {
		double monto = (sueldoBruto * PORCENTAJE_OBRA_SOCIAL) + (cantHijos * MONTO_OBRA_SOCIAL_POR_HIJO);
		return new Concepto("Obra Social", monto);
	}
	
	private Concepto retencionAportesJubilatorios(double sueldoBruto) {
		return new Concepto("Aportes Jubilatorios", sueldoBruto * PORCENTAJE_APORTES_JUBILATORIOS);
	}

	public static ConceptosPermanenteProvider getInstance() {
        if (instance == null) {
            instance = new ConceptosPermanenteProvider();
        }
        return instance;
	}
}
