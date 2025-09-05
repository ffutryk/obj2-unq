package ar.edu.unq.poo2.tp02;

import java.util.HashSet;
import java.util.Set;

public class ConceptosTemporalProvider extends ConceptosProvider {
	private static ConceptosTemporalProvider instance;
	
    private static final double BONO_POR_HORA_EXTRA = 40.0;
    private static final double PORCENTAJE_OBRA_SOCIAL = 0.10;
    private static final double MONTO_OBRA_SOCIAL_POR_EDAD = 25.0;
    private static final double PORCENTAJE_APORTES_JUBILATORIOS = 0.10;
    private static final double APORTES_JUBILATORIOS_POR_HORA_EXTRA = 5.0;
    private static final int EDAD_LIMITE_OBRA_SOCIAL = 50;
	
	@Override
	public Set<Concepto> bonos(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoTemporal.class);
		
		EmpleadoTemporal empleado = (EmpleadoTemporal) e;
		Set<Concepto> bonos = new HashSet<Concepto>();
		
		bonos.add(bonoHorasExtra(empleado.getHorasExtra()));
		
		return bonos;
	}

	@Override
	public Set<Concepto> retenciones(Empleado e) {
		validarEmpleadoEsInstanciaDe(e, EmpleadoTemporal.class);
		
		EmpleadoTemporal empleado = (EmpleadoTemporal) e;
		Set<Concepto> retenciones = new HashSet<Concepto>();
		
		double brutoEmpleado = empleado.sueldoBruto();
		
		retenciones.add(retencionObraSocial(brutoEmpleado, empleado.edad()));
		retenciones.add(retencionAportesJubilatorios(brutoEmpleado, empleado.getHorasExtra()));
		
		return retenciones;
	}
	
	private Concepto bonoHorasExtra(int horasExtra) {
		return new Concepto("Horas Extra", horasExtra * BONO_POR_HORA_EXTRA);
	}
	
	private Concepto retencionObraSocial(double sueldoBruto, int edad) {
		double monto = (sueldoBruto * PORCENTAJE_OBRA_SOCIAL) + (edad > EDAD_LIMITE_OBRA_SOCIAL ? MONTO_OBRA_SOCIAL_POR_EDAD : 0);
		return new Concepto("Obra Social", monto);
	}
	
	private Concepto retencionAportesJubilatorios(double sueldoBruto, int horasExtra) {
		double monto = (sueldoBruto * PORCENTAJE_APORTES_JUBILATORIOS) + (horasExtra * APORTES_JUBILATORIOS_POR_HORA_EXTRA);
		return new Concepto("Aportes Jubilatorios", monto);
	}
	
	public static ConceptosTemporalProvider getInstance() {
        if (instance == null) {
            instance = new ConceptosTemporalProvider();
        }
        return instance;
	}
}
