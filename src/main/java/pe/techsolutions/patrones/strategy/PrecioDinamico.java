package pe.techsolutions.patrones.strategy;

public class PrecioDinamico implements EstrategiaPrecio {

    private final double factorDemanda;

    public PrecioDinamico(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * factorDemanda;
    }
}

