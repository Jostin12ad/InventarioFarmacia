package patrones.decorator;

public class VentaImportante implements OperacionDeVenta {
    private OperacionDeVenta operacion;

    public VentaImportante(OperacionDeVenta operacion) {
        this.operacion = operacion;
    }

    @Override
    public void ejecutar() {
        System.out.println("Venta urgente");
        operacion.ejecutar();
        System.out.println("Se notificó al sistema de urgencia.");
    }

    
    public OperacionDeVenta getBase() {
        return operacion;
    }
}
