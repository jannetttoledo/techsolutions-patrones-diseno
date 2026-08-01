package pe.techsolutions.patrones.adapter;

public class YapeServicio {

    public boolean enviarPago(double valor) {
        System.out.println("Pago de S/ " + valor + " procesado mediante Yape.");
        return true;
    }
}

