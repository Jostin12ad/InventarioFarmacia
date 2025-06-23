package patrones.observer;

import modelos.Medicamento;

public interface Subject {
    void agregarObserver(Observer o);
    void eliminarObserver(Observer o);
    void notificar(Medicamento Medicamento);
}
