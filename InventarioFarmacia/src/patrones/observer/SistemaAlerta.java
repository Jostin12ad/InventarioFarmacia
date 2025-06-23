package patrones.observer;

import modelos.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class SistemaAlerta implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void agregarObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void eliminarObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificar(Medicamento medicamento) {
        for (Observer o : observers) {
            o.actualizar(medicamento);
        }
    }
}
