package pe.techsolutions.patrones.command;

public class Pedido {

    private final String numeroPedido;
    private final double totalBase;
    private String estado;
    private double descuento;

    public Pedido(String numeroPedido, double totalBase) {
        this.numeroPedido = numeroPedido;
        this.totalBase = totalBase;
        this.estado = "NUEVO";
        this.descuento = 0;
    }

    public void crear() {
        estado = "CREADO";
        System.out.println("Pedido " + numeroPedido + " creado.");
    }

    public void procesar() {
        estado = "PROCESADO";
        System.out.println("Pedido " + numeroPedido + " procesado.");
    }

    public void aplicarDescuento(double porcentaje) {
        descuento = porcentaje;
        System.out.println("Descuento de " + porcentaje
                + "% aplicado al pedido " + numeroPedido + ".");
    }

    public void cancelar() {
        estado = "CANCELADO";
        System.out.println("Pedido " + numeroPedido + " cancelado.");
    }

    public EstadoPedidoMemento guardarEstado() {
        return new EstadoPedidoMemento(estado, descuento);
    }

    public void restaurarEstado(EstadoPedidoMemento memento) {
        estado = memento.getEstado();
        descuento = memento.getDescuento();

        System.out.println("Pedido restaurado al estado: " + estado);
    }

    public void mostrarResumen() {
        double totalFinal = totalBase - (totalBase * descuento / 100);

        System.out.println("---------------");
        System.out.println("Pedido: " + numeroPedido);
        System.out.println("Estado: " + estado);
        System.out.println("Descuento: " + descuento + "%");
        System.out.println("Total final: S/ " + totalFinal);
        System.out.println("---------------");
    }
}

