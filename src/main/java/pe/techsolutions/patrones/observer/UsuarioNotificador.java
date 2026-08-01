package pe.techsolutions.patrones.observer;

public class UsuarioNotificador implements ObservadorStock {

    private final String nombre;
    private final String rol;

    public UsuarioNotificador(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + rol + " " + nombre + ": " + mensaje);
    }
}

