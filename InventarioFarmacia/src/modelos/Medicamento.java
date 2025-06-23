package modelos;

import java.time.LocalDate;

public abstract class Medicamento {
    protected String nombre;
    protected int stock;
    protected LocalDate fechaVencimiento;
    protected double precio;  // Nuevo atributo precio

    public Medicamento(String nombre, int stock, LocalDate fechaVencimiento, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean estaPorVencer() {
        return fechaVencimiento.isBefore(LocalDate.now().plusDays(30));
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " | Stock: " + stock + " | Precio: $" + precio + " | Vence: " + fechaVencimiento;
    }
}
