package pe.techsolutions.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.techsolutions.patrones.adapter.GestorPasarelasPago;
import pe.techsolutions.patrones.adapter.PayPalAdapter;
import pe.techsolutions.patrones.adapter.PayPalServicio;
import pe.techsolutions.patrones.adapter.PlinAdapter;
import pe.techsolutions.patrones.adapter.PlinServicio;
import pe.techsolutions.patrones.adapter.YapeAdapter;
import pe.techsolutions.patrones.adapter.YapeServicio;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    private final GestorPasarelasPago gestor;
    private final Map<String, Boolean> estadosPasarelas;

    public PagoController() {
        gestor = new GestorPasarelasPago();
        estadosPasarelas = new HashMap<>();

        gestor.registrarPasarela(new PayPalAdapter(new PayPalServicio()));
        gestor.registrarPasarela(new YapeAdapter(new YapeServicio()));
        gestor.registrarPasarela(new PlinAdapter(new PlinServicio()));

        estadosPasarelas.put("PayPal", true);
        estadosPasarelas.put("Yape", true);
        estadosPasarelas.put("Plin", true);
    }

    @PostMapping("/procesar")
    public ResponseEntity<Map<String, Object>> procesarPago(
            @RequestBody SolicitudPago solicitud) {

        Map<String, Object> respuesta = new HashMap<>();

        String pasarela = normalizarPasarela(solicitud.getPasarela());

        if (pasarela == null) {
            respuesta.put("exito", false);
            respuesta.put("mensaje", "La pasarela seleccionada no es válida.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        if (solicitud.getMonto() <= 0) {
            respuesta.put("exito", false);
            respuesta.put("mensaje", "El monto debe ser mayor que cero.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        boolean pagoExitoso = gestor.procesarPago(pasarela, solicitud.getMonto());

        respuesta.put("exito", pagoExitoso);
        respuesta.put("pasarela", pasarela);
        respuesta.put("monto", solicitud.getMonto());

        if (pagoExitoso) {
            respuesta.put("mensaje",
                    "Pago procesado correctamente mediante " + pasarela + ".");
        } else {
            respuesta.put("mensaje",
                    "No se pudo procesar el pago. Verifica que la pasarela esté habilitada.");
        }

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/estado")
    public ResponseEntity<Map<String, Object>> cambiarEstado(
            @RequestBody SolicitudEstado solicitud) {

        Map<String, Object> respuesta = new HashMap<>();

        String pasarela = normalizarPasarela(solicitud.getPasarela());

        if (pasarela == null) {
            respuesta.put("exito", false);
            respuesta.put("mensaje", "La pasarela seleccionada no es válida.");
            return ResponseEntity.badRequest().body(respuesta);
        }

        gestor.cambiarEstado(pasarela, solicitud.isHabilitada());
        estadosPasarelas.put(pasarela, solicitud.isHabilitada());

        respuesta.put("exito", true);
        respuesta.put("pasarela", pasarela);
        respuesta.put("habilitada", solicitud.isHabilitada());
        respuesta.put("mensaje", pasarela + " fue "
                + (solicitud.isHabilitada() ? "habilitada." : "deshabilitada."));

        return ResponseEntity.ok(respuesta);
    }

    private String normalizarPasarela(String pasarela) {
        if (pasarela == null) {
            return null;
        }

        return switch (pasarela.trim().toLowerCase()) {
            case "paypal" -> "PayPal";
            case "yape" -> "Yape";
            case "plin" -> "Plin";
            default -> null;
        };
    }

    public static class SolicitudPago {

        private String pasarela;
        private double monto;

        public String getPasarela() {
            return pasarela;
        }

        public void setPasarela(String pasarela) {
            this.pasarela = pasarela;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }
    }

    public static class SolicitudEstado {

        private String pasarela;
        private boolean habilitada;

        public String getPasarela() {
            return pasarela;
        }

        public void setPasarela(String pasarela) {
            this.pasarela = pasarela;
        }

        public boolean isHabilitada() {
            return habilitada;
        }

        public void setHabilitada(boolean habilitada) {
            this.habilitada = habilitada;
        }
    }
}

