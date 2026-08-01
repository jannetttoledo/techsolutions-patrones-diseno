package pe.techsolutions.patrones.adapter;

public class PayPalServicio {

    public boolean realizarCobro(double importe) {
        System.out.println("Pago de S/ " + importe + " procesado mediante PayPal.");
        return true;
    }
}
