package modelos;

import patrones.iterator.IteradorMedicamentos;
import patrones.iterator.ColeccionMedicamentos;

import java.util.ArrayList;
import java.util.List;

public class Inventario implements ColeccionMedicamentos {
    private List<Medicamento> medicamentos;

    public Inventario() {
        this.medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public Medicamento buscarPorNombre(String nombre) {
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    // Aquí se aplica el patrón Iterator
    @Override
    public IteradorMedicamentos crearIterador() {
        return new IteradorMedicamentos(medicamentos);
    }
}