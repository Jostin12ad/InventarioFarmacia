# 🩺 Sistema de Gestión de Farmacia

## 🎯 Objetivo General  
Desarrollar un proyecto en Java estándar que integre de forma práctica los patrones de diseño GoF, aplicándolos en una solución funcional, con una justificación técnica clara y una defensa oral argumentada.

---

## 📝 Descripción General del Sistema  
Este sistema está diseñado para administrar el inventario de medicamentos en una farmacia comunitaria. Permite:

- Registrar diferentes tipos de medicamentos  
- Controlar el stock  
- Gestionar fechas de vencimiento  
- Realizar ventas  
- Generar alertas automatizadas  
- Mantener un historial de transacciones

*Problema que resuelve:*  
Muchas farmacias llevan el control de su inventario de forma manual, lo que provoca errores, desorden y falta de trazabilidad. Este sistema mejora la precisión, facilita la operación diaria y mantiene un inventario ordenado, actualizado y auditable.

---

## 🧩 Patrones de Diseño Aplicados

### 🏭 1. Factory Method (Creacional)
*¿Por qué?*  
Se requiere manejar distintos tipos de medicamentos (genéricos, controlados, refrigerados), cada uno con características propias. Para evitar la dependencia directa con las clases concretas y facilitar futuras extensiones, se utiliza el patrón Factory Method.

*¿Cómo?*  
Se implementa una clase fábrica FabricaMedicamentos, que recibe los datos del medicamento y retorna una instancia del tipo correspondiente.

*¿Dónde?*  
En el método agregarMedicamento() dentro de Main, donde se instancia el medicamento según el tipo indicado.

---

### 🎁 2. Decorator (Estructural)
*¿Por qué?*  
Al realizar ventas, puede requerirse funcionalidad adicional (como marcar una venta como urgente) sin modificar la clase base VentaSimple. El patrón Decorator permite extender dinámicamente el comportamiento.

*¿Cómo?*  
La clase VentaImportante implementa la interfaz OperacionDeVenta y envuelve una instancia de VentaSimple. Agrega mensajes o procesos antes o después de la venta.

*¿Dónde?*  
En el método realizarVenta() de Main, si la venta es urgente se utiliza VentaImportante para decorarla.

---

### 👁 3. Observer (Comportamental)
*¿Por qué?*  
El sistema debe generar alertas cuando hay stock bajo o vencimientos próximos. Para desacoplar la lógica del inventario de las alertas, se utiliza Observer.

*¿Cómo?*  
SistemaAlerta actúa como sujeto (Subject) y mantiene una lista de observadores (AlertaStock, AlertaVencimiento). Cuando se modifica el stock, notifica automáticamente a los observadores.

*¿Dónde?*  
En realizarVenta(), después de completar la venta se ejecuta sistemaAlerta.notificar(medicamento) para comprobar si se deben generar alertas.

---

### 🔄 4. Iterator (Libre elección)
*¿Por qué?*  
El inventario contiene una colección de medicamentos que no debe ser expuesta directamente. Para recorrerla de manera segura y encapsulada, se utiliza el patrón Iterator.

*¿Cómo?*  
La clase Inventario implementa el método crearIterador(), que devuelve un objeto IteradorMedicamentos con métodos como tieneSiguiente() y siguiente().

*¿Dónde?*  
Se utiliza en métodos como mostrarMedicamentos() y simularAlertas() para recorrer los medicamentos sin acceder directamente a la estructura interna.

---

## ⚙ Instrucciones de Compilación y Ejecución

### 🛠 Compilación  
Desde la raíz del proyecto, ejecutar en consola:

```bash
javac -d bin src//*.java

























