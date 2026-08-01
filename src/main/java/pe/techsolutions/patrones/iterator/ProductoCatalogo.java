package pe.techsolutions.patrones.iterator;

public class ProductoCatalogo {

    private final String codigo;
    private final String nombre;
    private final double precio;

    public ProductoCatalogo(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Producto: " + nombre
                + " | Precio: S/ " + precio;
    }
}

