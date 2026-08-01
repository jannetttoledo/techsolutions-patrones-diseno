package pe.techsolutions.patrones.adapter;

public class PlinServicio {

    public boolean confirmarTransaccion(double cantidad) {
        System.out.println("Pago de S/ " + cantidad + " procesado mediante Plin.");
        return true;
    }
}
