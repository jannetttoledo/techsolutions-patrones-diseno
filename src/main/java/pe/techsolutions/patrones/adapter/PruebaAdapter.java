package pe.techsolutions.patrones.adapter;

public class PruebaAdapter {

    public static void main(String[] args) {

        GestorPasarelasPago gestor = new GestorPasarelasPago();

        gestor.registrarPasarela(
                new PayPalAdapter(new PayPalServicio())
        );

        gestor.registrarPasarela(
                new YapeAdapter(new YapeServicio())
        );

        gestor.registrarPasarela(
                new PlinAdapter(new PlinServicio())
        );

        System.out.println("--- Pagos habilitados ---");
        gestor.procesarPago("PayPal", 100.00);
        gestor.procesarPago("Yape", 50.00);
        gestor.procesarPago("Plin", 75.00);

        System.out.println("\n--- Deshabilitar Yape ---");
        gestor.cambiarEstado("Yape", false);

        gestor.procesarPago("Yape", 30.00);
    }
}

