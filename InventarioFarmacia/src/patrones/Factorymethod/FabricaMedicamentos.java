package patrones.Factorymethod;

import modelos.*;

import java.time.LocalDate;

public class FabricaMedicamentos {

    // se aplica el patrón Factory Method
    public static Medicamento crearMedicamento(String nombre, int tipo, int stock, LocalDate fechaVencimiento, double precio) {
        return switch (tipo) {
            case 1 -> new MedicamentoGenerico(nombre, stock, fechaVencimiento, precio);
            case 2 -> new MedicamentoControlado(nombre, stock, fechaVencimiento, precio);
            case 3 -> new MedicamentoRefrigerado(nombre, stock, fechaVencimiento, precio);
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}