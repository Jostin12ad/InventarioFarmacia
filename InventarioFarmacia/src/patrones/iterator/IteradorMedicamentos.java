package patrones.iterator;

import modelos.Medicamento;

import java.util.List;

public class IteradorMedicamentos {
    private List<Medicamento> medicamentos;
    private int posicion = 0;

    public IteradorMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean tieneSiguiente() {
        return posicion < medicamentos.size();
    }

    public Medicamento siguiente() {
        if (tieneSiguiente()) {
            return medicamentos.get(posicion++);
        }
        return null;
    }
}