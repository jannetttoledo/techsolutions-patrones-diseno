package pe.techsolutions.patrones.adapter;

public class YapeAdapter implements PasarelaPago {

    private final YapeServicio yapeServicio;

    public YapeAdapter(YapeServicio yapeServicio) {
        this.yapeServicio = yapeServicio;
    }

    @Override
    public boolean procesarPago(double monto) {
        return yapeServicio.enviarPago(monto);
    }

    @Override
    public String obtenerNombre() {
        return "Yape";
    }
}

