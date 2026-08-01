package pe.techsolutions.patrones.command;

public class AplicarDescuentoComando implements ComandoPedido {

    private final Pedido pedido;
    private final double porcentaje;
    private EstadoPedidoMemento respaldo;

    public AplicarDescuentoComando(Pedido pedido, double porcentaje) {
        this.pedido = pedido;
        this.porcentaje = porcentaje;
    }

    @Override
    public void ejecutar() {
        respaldo = pedido.guardarEstado();
        pedido.aplicarDescuento(porcentaje);
    }

    @Override
    public void deshacer() {
        pedido.restaurarEstado(respaldo);
    }
}

