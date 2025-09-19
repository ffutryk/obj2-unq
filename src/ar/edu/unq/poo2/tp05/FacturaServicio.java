package ar.edu.unq.poo2.tp05;

public class FacturaServicio extends Factura {
	private double costoUnitario;
	private int cantidadConsumida;
	
	public FacturaServicio(Agencia agencia, double costoUnitario, int cantidadConsumida) {
		super(agencia);
		this.costoUnitario = costoUnitario;
		this.cantidadConsumida = cantidadConsumida;
	}

	@Override
	public double monto() {
		return costoUnitario * cantidadConsumida;
	}

}
