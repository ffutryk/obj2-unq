package ar.edu.unq.poo2.tp05;

import java.util.List;

public class Caja {
	// Técnicamente rompe con SRP al tener la responsabilidad de calcular el monto y mandar las "notificaciones".
	public double montoTotal(List<Pagable> objetos) {
		return objetos.stream()
				.peek(Pagable::alSerPagado)
				.mapToDouble(Pagable::monto)
				.sum();
	}
}
