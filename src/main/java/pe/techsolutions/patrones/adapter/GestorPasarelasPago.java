package pe.techsolutions.patrones.adapter;

import java.util.HashMap;
import java.util.Map;

public class GestorPasarelasPago {

    private final Map<String, PasarelaPago> pasarelas;
    private final Map<String, Boolean> estados;

    public GestorPasarelasPago() {
        pasarelas = new HashMap<>();
        estados = new HashMap<>();
    }

    public void registrarPasarela(PasarelaPago pasarela) {
        String nombre = pasarela.obtenerNombre();
        pasarelas.put(nombre, pasarela);
        estados.put(nombre, true);
    }

    public void cambiarEstado(String nombrePasarela, boolean habilitada) {
        if (pasarelas.containsKey(nombrePasarela)) {
            estados.put(nombrePasarela, habilitada);
            System.out.println(nombrePasarela + " fue "
                    + (habilitada ? "habilitada." : "deshabilitada."));
        } else {
            System.out.println("La pasarela no está registrada.");
        }
    }

    public boolean procesarPago(String nombrePasarela, double monto) {
        PasarelaPago pasarela = pasarelas.get(nombrePasarela);

        if (pasarela == null) {
            System.out.println("La pasarela solicitada no existe.");
            return false;
        }

        if (!estados.get(nombrePasarela)) {
            System.out.println("La pasarela " + nombrePasarela
                    + " está deshabilitada.");
            return false;
        }

        return pasarela.procesarPago(monto);
    }
}
