package pe.techsolutions.patrones.iterator;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProductos {

    private final List<ProductoCatalogo> productos;

    public CatalogoProductos() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoCatalogo producto) {
        productos.add(producto);
    }

    public IteradorProductos crearIterador() {
        return new IteradorCatalogo();
    }

    private class IteradorCatalogo implements IteradorProductos {

        private int posicion = 0;

        @Override
        public boolean tieneSiguiente() {
            return posicion < productos.size();
        }

        @Override
        public ProductoCatalogo siguiente() {
            if (!tieneSiguiente()) {
                return null;
            }

            ProductoCatalogo producto = productos.get(posicion);
            posicion++;
            return producto;
        }
    }
}

