package modelos;

import java.time.LocalDate;


public class MedicamentoControlado extends Medicamento {
    public MedicamentoControlado(String nombre, int stock, LocalDate fechaVencimiento, double precio) {
        super(nombre, stock, fechaVencimiento, precio);
    }
}