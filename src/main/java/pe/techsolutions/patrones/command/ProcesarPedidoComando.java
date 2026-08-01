package pe.techsolutions.patrones.command;

public class ProcesarPedidoComando implements ComandoPedido {

    private final Pedido pedido;
    private EstadoPedidoMemento respaldo;

    public ProcesarPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        respaldo = pedido.guardarEstado();
        pedido.procesar();
    }

    @Override
    public void deshacer() {
        pedido.restaurarEstado(respaldo);
    }
}

