package pe.techsolutions.patrones.command;

public class EstadoPedidoMemento {

    private final String estado;
    private final double descuento;

    public EstadoPedidoMemento(String estado, double descuento) {
        this.estado = estado;
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public double getDescuento() {
        return descuento;
    }
}

