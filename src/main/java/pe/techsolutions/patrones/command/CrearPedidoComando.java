package pe.techsolutions.patrones.command;

public class CrearPedidoComando implements ComandoPedido {

    private final Pedido pedido;
    private EstadoPedidoMemento respaldo;

    public CrearPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        respaldo = pedido.guardarEstado();
        pedido.crear();
    }

    @Override
    public void deshacer() {
        pedido.restaurarEstado(respaldo);
    }
}
