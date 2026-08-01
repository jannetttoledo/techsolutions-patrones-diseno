package pe.techsolutions.patrones.iterator;

public class PruebaIterator {

    public static void main(String[] args) {
        CatalogoProductos catalogo = new CatalogoProductos();

        catalogo.agregarProducto(
                new ProductoCatalogo("P001", "Laptop Lenovo", 2500.00));

        catalogo.agregarProducto(
                new ProductoCatalogo("P002", "Mouse inalámbrico", 75.00));

        catalogo.agregarProducto(
                new ProductoCatalogo("P003", "Teclado mecánico", 180.00));

        IteradorProductos iterador = catalogo.crearIterador();

        System.out.println("CATÁLOGO DE PRODUCTOS");

        while (iterador.tieneSiguiente()) {
            System.out.println(iterador.siguiente());
        }
    }
}

