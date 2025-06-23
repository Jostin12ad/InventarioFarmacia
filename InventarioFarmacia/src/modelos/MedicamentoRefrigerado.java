package modelos;

import java.time.LocalDate;

public class MedicamentoRefrigerado extends Medicamento {
    public MedicamentoRefrigerado(String nombre, int stock, LocalDate fechaVencimiento, double precio) {
        super(nombre, stock, fechaVencimiento, precio);
    }
}