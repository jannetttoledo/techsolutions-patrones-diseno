package pe.techsolutions.patrones.strategy;

public class ConfiguradorPrecio {

    private EstrategiaPrecio estrategiaPrecio;

    public ConfiguradorPrecio(EstrategiaPrecio estrategiaPrecio) {
        this.estrategiaPrecio = estrategiaPrecio;
    }

    public void cambiarEstrategia(EstrategiaPrecio nuevaEstrategia) {
        estrategiaPrecio = nuevaEstrategia;
        System.out.println("Estrategia de precio actualizada.");
    }

    public double obtenerPrecioFinal(double precioBase) {
        return estrategiaPrecio.calcularPrecio(precioBase);
    }
}

    

