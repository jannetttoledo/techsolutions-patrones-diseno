package pe.techsolutions.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private final String nombre;
    private int stock;
    private int stockMinimo;
    private final List<ObservadorStock> observadores;

    public Producto(String nombre, int stock, int stockMinimo) {
        this.nombre = nombre;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorStock observador) {
        observadores.add(observador);
    }

    public void cambiarStock(int nuevoStock) {
        stock = nuevoStock;

        System.out.println("Stock actual de " + nombre + ": " + stock);

        if (stock < stockMinimo) {
            notificarStockBajo();
        }
    }

    public void cambiarStockMinimo(int nuevoStockMinimo) {
        stockMinimo = nuevoStockMinimo;
        System.out.println("Stock mínimo configurado para " + nombre + ": " + stockMinimo);
    }

    private void notificarStockBajo() {
        String mensaje = "Stock bajo de " + nombre
                + ". Stock actual: " + stock
                + ". Stock mínimo: " + stockMinimo;

        for (ObservadorStock observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}

