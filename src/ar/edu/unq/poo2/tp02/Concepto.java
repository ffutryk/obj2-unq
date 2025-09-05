package ar.edu.unq.poo2.tp02;

public final class Concepto {
    private final String descripcion;
    private final double monto;

    public Concepto(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }
}