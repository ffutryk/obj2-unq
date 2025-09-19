package ar.edu.unq.poo2.tp05;

public abstract class Factura implements Pagable {
	private Agencia agencia;
	
	public Factura(Agencia agencia) {
		this.agencia = agencia;
	}

	public abstract double monto();
	
	public void alSerPagado() {
		agencia.registrarPago(this);
	}
}
