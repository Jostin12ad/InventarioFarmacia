package patrones.observer;

import modelos.Medicamento;

public class AlertaStock implements Observer {

    @Override
    public void actualizar(Medicamento medicamento) {
        if (medicamento.getStock() < 5) {
            System.out.println("⚠️ Alerta: Stock bajo para " + medicamento.getNombre());
        }
    }
}
