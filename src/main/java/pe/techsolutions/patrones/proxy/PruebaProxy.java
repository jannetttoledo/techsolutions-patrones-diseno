package pe.techsolutions.patrones.proxy;

public class PruebaProxy {

    public static void main(String[] args) {
        ReporteFinanciero reporte = new ReporteFinancieroProxy();

        Usuario gerente = new Usuario("Ana Torres", "Gerente", "1234");
        Usuario contador = new Usuario("Luis Ramos", "Contador", "abcd");
        Usuario vendedor = new Usuario("María Díaz", "Vendedor", "9876");

        System.out.println("--- ACCESO DE GERENTE ---");
        reporte.mostrarReporte(gerente, "1234");

        System.out.println("\n--- ACCESO DE CONTADOR ---");
        reporte.mostrarReporte(contador, "abcd");

        System.out.println("\n--- ACCESO DE VENDEDOR ---");
        reporte.mostrarReporte(vendedor, "9876");
    }
}

