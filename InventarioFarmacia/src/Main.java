import modelos.*;
import patrones.Factorymethod.*;
import patrones.decorator.*;
import patrones.observer.*;
import patrones.iterator.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Inventario inventario = new Inventario();
    private static SistemaAlerta sistemaAlerta = new SistemaAlerta();
    private static List<RegistroDeVenta> historialDeVentas = new ArrayList<>();

    public static void main(String[] args) {
        sistemaAlerta.agregarObserver(new AlertaStock());
        sistemaAlerta.agregarObserver(new AlertaVencimiento());

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA INVENTARIO FARMACIA =====");
            System.out.println("1. Agregar nuevo medicamento");
            System.out.println("2. Realizar venta");
            System.out.println("3. Mostrar todos los medicamentos");
            System.out.println("4. Buscar medicamento por nombre");
            System.out.println("5. Ver alertas (simulación)");
            System.out.println("6. Ver historial de ventas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarMedicamento(scanner);
                case 2 -> realizarVenta(scanner);
                case 3 -> mostrarMedicamentos();
                case 4 -> buscarMedicamento(scanner);
                case 5 -> simularAlertas();
                case 6 -> mostrarHistorial();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarMedicamento(Scanner scanner) {
        try {
            System.out.print("Nombre del medicamento: ");
            String nombre = scanner.nextLine();

            System.out.println("Tipo (1: Genérico, 2: Controlado, 3: Refrigerado): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Stock inicial: ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Precio unitario: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            LocalDate fechaVencimiento = LocalDate.parse(fechaStr);

            Medicamento nuevo = FabricaMedicamentos.crearMedicamento(nombre, tipo, stock, fechaVencimiento, precio);
            inventario.agregarMedicamento(nuevo);
            System.out.println("Medicamento registrado.");
        } catch (Exception e) {
            System.out.println("Error al registrar medicamento: " + e.getMessage());
        }
    }

    private static void realizarVenta(Scanner scanner) {
        System.out.print("Nombre del medicamento: ");
        String nombre = scanner.nextLine();
        Medicamento med = inventario.buscarPorNombre(nombre);

        if (med == null) {
            System.out.println("Medicamento no encontrado.");
            return;
        }

        System.out.print("Cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Venta urgente? (s/n): ");
        String urg = scanner.nextLine();

        OperacionDeVenta venta = new VentaSimple(med, cantidad);
        if (urg.equalsIgnoreCase("s")) {
            venta = new VentaImportante(venta);
        }

        venta.ejecutar();
        sistemaAlerta.notificar(med);

        double total = 0.0;
        if (venta instanceof VentaSimple vs) {
            total = vs.getTotalVenta();
            System.out.printf("Total de la venta: $%.2f%n", total);
        } else if (venta instanceof VentaImportante vi && vi.getBase() instanceof VentaSimple vs) {
            total = vs.getTotalVenta();
            System.out.printf("Total de la venta: $%.2f%n", total);
        }

        historialDeVentas.add(new RegistroDeVenta(med.getNombre(), cantidad, total));
    }

    private static void mostrarMedicamentos() {
        IteradorMedicamentos iter = inventario.crearIterador();
        System.out.println("Inventario:");
        while (iter.tieneSiguiente()) {
            Medicamento m = iter.siguiente();
            System.out.println("- " + m);
        }
    }

    private static void buscarMedicamento(Scanner scanner) {
        System.out.print("Nombre del medicamento: ");
        String nombre = scanner.nextLine();
        Medicamento m = inventario.buscarPorNombre(nombre);
        if (m != null) {
            System.out.println("Resultado: " + m);
        } else {
            System.out.println("No se encontró el medicamento.");
        }
    }

    private static void simularAlertas() {
        IteradorMedicamentos iter = inventario.crearIterador();
        while (iter.tieneSiguiente()) {
            sistemaAlerta.notificar(iter.siguiente());
        }
    }

    private static void mostrarHistorial() {
        System.out.println("\n=== Historial de Ventas ===");
        if (historialDeVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (RegistroDeVenta rv : historialDeVentas) {
                System.out.println(rv);
            }
        }
    }
}

