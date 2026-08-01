package pe.techsolutions.patrones.command;

public class CancelarPedidoComando implements ComandoPedido {

    private final Pedido pedido;
    private EstadoPedidoMemento respaldo;

    public CancelarPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        respaldo = pedido.guardarEstado();
        pedido.cancelar();
    }

    @Override
    public void deshacer() {
        pedido.restaurarEstado(respaldo);
    }
}

