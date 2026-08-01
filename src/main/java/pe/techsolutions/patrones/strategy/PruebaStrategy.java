package pe.techsolutions.patrones.strategy;

public class PruebaStrategy {

    public static void main(String[] args) {
        double precioBase = 100.00;

        ConfiguradorPrecio configurador =
                new ConfiguradorPrecio(new PrecioEstandar());

        System.out.println("Precio estándar: S/ "
                + configurador.obtenerPrecioFinal(precioBase));

        configurador.cambiarEstrategia(new DescuentoPorcentual(15));
        System.out.println("Precio con descuento: S/ "
                + configurador.obtenerPrecioFinal(precioBase));

        configurador.cambiarEstrategia(new PrecioDinamico(1.20));
        System.out.println("Precio dinámico: S/ "
                + configurador.obtenerPrecioFinal(precioBase));
    }
}

    

