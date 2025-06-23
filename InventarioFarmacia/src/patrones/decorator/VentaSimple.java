package patrones.decorator;

import modelos.Medicamento;

public class VentaSimple implements OperacionDeVenta {
    private Medicamento medicamento;
    private int cantidad;
    private double totalVenta;

    public VentaSimple(Medicamento medicamento, int cantidad) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() {
        if (medicamento.getStock() >= cantidad) {
            medicamento.reducirStock(cantidad);
            totalVenta = medicamento.getPrecio() * cantidad; 
            System.out.println("Venta realizada: " + cantidad + " unidades de " + medicamento.getNombre());
            System.out.printf("Total: $%.2f%n", totalVenta); 
        } else {
            System.out.println("No hay suficiente stock para la venta.");
        }
    }

    public double getTotalVenta() {
        return totalVenta;
    }
}
