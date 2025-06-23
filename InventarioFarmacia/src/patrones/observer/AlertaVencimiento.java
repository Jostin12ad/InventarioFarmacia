package patrones.observer;

import modelos.Medicamento;

public class AlertaVencimiento implements Observer {

    @Override
    public void actualizar(Medicamento Medicamento) {
        if (Medicamento.estaPorVencer()) {
            System.out.println("Alerta: Este medicamento esta por vencer " + Medicamento.getNombre());
        }
    }
}
