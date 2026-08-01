package pe.techsolutions.patrones.command;

import java.util.Stack;

public class HistorialComandos {

    private final Stack<ComandoPedido> historial;

    public HistorialComandos() {
        historial = new Stack<>();
    }

    public void ejecutarComando(ComandoPedido comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimaAccion() {
        if (historial.isEmpty()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }

        ComandoPedido comando = historial.pop();
        comando.deshacer();
    }
}

