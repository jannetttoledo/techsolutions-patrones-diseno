package pe.techsolutions.patrones.strategy;

public class PrecioEstandar implements EstrategiaPrecio {

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase;
    }
}

