package pe.techsolutions.patrones.proxy;

public class ReporteFinancieroProxy implements ReporteFinanciero {

    private final ReporteFinancieroReal reporteReal;

    public ReporteFinancieroProxy() {
        reporteReal = new ReporteFinancieroReal();
    }

    @Override
    public void mostrarReporte(Usuario usuario, String clave) {
        boolean claveCorrecta = usuario.validarClave(clave);

        boolean tieneRolAutorizado =
                usuario.getRol().equalsIgnoreCase("Gerente")
                || usuario.getRol().equalsIgnoreCase("Contador");

        if (claveCorrecta && tieneRolAutorizado) {
            reporteReal.mostrarReporte(usuario, clave);
        } else {
            System.out.println("ACCESO DENEGADO.");
            System.out.println("Solo Gerente o Contador pueden ver el reporte.");
        }
    }
}

