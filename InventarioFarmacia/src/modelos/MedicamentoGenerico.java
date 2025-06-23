package modelos;

import java.time.LocalDate;

public class MedicamentoGenerico extends Medicamento {
    public MedicamentoGenerico(String nombre, int stock, LocalDate fechaVencimiento, double precio) {
        super(nombre, stock, fechaVencimiento, precio);
    }
}