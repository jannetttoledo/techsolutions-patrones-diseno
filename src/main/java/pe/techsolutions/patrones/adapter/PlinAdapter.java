package pe.techsolutions.patrones.adapter;

public class PlinAdapter implements PasarelaPago {

    private final PlinServicio plinServicio;

    public PlinAdapter(PlinServicio plinServicio) {
        this.plinServicio = plinServicio;
    }

    @Override
    public boolean procesarPago(double monto) {
        return plinServicio.confirmarTransaccion(monto);
    }

    @Override
    public String obtenerNombre() {
        return "Plin";
    }
}

