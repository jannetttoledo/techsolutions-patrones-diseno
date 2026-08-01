package pe.techsolutions.patrones.proxy;

public class Usuario {

    private final String nombre;
    private final String rol;
    private final String clave;

    public Usuario(String nombre, String rol, String clave) {
        this.nombre = nombre;
        this.rol = rol;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public boolean validarClave(String claveIngresada) {
        return clave.equals(claveIngresada);
    }
}

