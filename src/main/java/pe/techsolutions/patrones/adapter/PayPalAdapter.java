package pe.techsolutions.patrones.adapter;

public class PayPalAdapter implements PasarelaPago {

    private final PayPalServicio payPalServicio;

    public PayPalAdapter(PayPalServicio payPalServicio) {
        this.payPalServicio = payPalServicio;
    }

    @Override
    public boolean procesarPago(double monto) {
        return payPalServicio.realizarCobro(monto);
    }

    @Override
    public String obtenerNombre() {
        return "PayPal";
    }
}

