package ar.edu.unq.poo2.tp05;

public class Producto implements Pagable {
	private double precio;
	private int stock;
	
	public Producto(double precio, int stock) {
		this.precio = precio;
		this.stock = stock;
	}
	
	public double monto() {
		return precio;
	}
	
	public void alSerPagado() {
		stock -= 1;
	}
}
