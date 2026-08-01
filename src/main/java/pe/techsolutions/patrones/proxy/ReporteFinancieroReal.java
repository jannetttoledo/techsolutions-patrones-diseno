package pe.techsolutions.patrones.proxy;

public class ReporteFinancieroReal implements ReporteFinanciero {

    @Override
    public void mostrarReporte(Usuario usuario, String clave) {
        System.out.println("=================================");
        System.out.println("REPORTE FINANCIERO COMPLETO");
        System.out.println("Usuario autorizado: " + usuario.getNombre());
        System.out.println("Ventas totales: S/ 25,000.00");
        System.out.println("Gastos totales: S/ 10,000.00");
        System.out.println("Utilidad neta: S/ 15,000.00");
        System.out.println("=================================");
    }
}

