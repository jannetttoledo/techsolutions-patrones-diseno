package pe.techsolutions.patrones.strategy;

public class DescuentoPorcentual implements EstrategiaPrecio {

    private final double porcentajeDescuento;

    public DescuentoPorcentual(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase - (precioBase * porcentajeDescuento / 100);
    }
}

