package pe.techsolutions.patrones.adapter;

public interface PasarelaPago {

    boolean procesarPago(double monto);

    String obtenerNombre();
}
