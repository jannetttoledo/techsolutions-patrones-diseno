package pe.techsolutions.patrones.observer;

public class PruebaObserver {

    public static void main(String[] args) {
        Producto producto = new Producto("Laptop Lenovo", 10, 5);

        ObservadorStock gerente =
                new UsuarioNotificador("Ana Torres", "Gerente");

        ObservadorStock compras =
                new UsuarioNotificador("Luis Ramos", "Compras");

        producto.agregarObservador(gerente);
        producto.agregarObservador(compras);

        producto.cambiarStock(3);
    }
}

