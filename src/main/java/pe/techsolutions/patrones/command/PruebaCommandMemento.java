package pe.techsolutions.patrones.command;

public class PruebaCommandMemento {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-001", 500.00);
        HistorialComandos historial = new HistorialComandos();

        historial.ejecutarComando(new CrearPedidoComando(pedido));
        historial.ejecutarComando(new ProcesarPedidoComando(pedido));
        historial.ejecutarComando(
                new AplicarDescuentoComando(pedido, 10));

        pedido.mostrarResumen();

        System.out.println("DESHACIENDO DESCUENTO...");
        historial.deshacerUltimaAccion();

        pedido.mostrarResumen();

        System.out.println("CANCELANDO PEDIDO...");
        historial.ejecutarComando(new CancelarPedidoComando(pedido));

        pedido.mostrarResumen();

        System.out.println("DESHACIENDO CANCELACIÓN...");
        historial.deshacerUltimaAccion();

        pedido.mostrarResumen();
    }
}

