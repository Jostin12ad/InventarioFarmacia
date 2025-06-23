package modelos;

import java.time.LocalDateTime;

public class RegistroDeVenta {
    private String nombreMedicamento;
    private int cantidad;
    private double total;
    private LocalDateTime fecha;

    public RegistroDeVenta(String nombreMedicamento, int cantidad, double total) {
        this.nombreMedicamento = nombreMedicamento;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public String toString() {
        return fecha + " | " + nombreMedicamento + " | Cantidad: " + cantidad + " | Total: $" + total;
    }
}
