package ar.edu.unq.poo2.tp05;

public class ProductoCooperativa extends Producto {
	private final int PORCENTAJE_IVA = 10;
	
	public ProductoCooperativa(double precio, int stock) {
		super(precio, stock);
	}

	@Override
	public double monto() {
		return aplicarDescuentoIVA(super.monto());
	}
	
	private double aplicarDescuentoIVA(double monto) {
		return monto - (1 - PORCENTAJE_IVA / 100.0);
	}
}
