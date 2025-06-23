🩺 Sistema de Gestión de Farmacia
🎯 Objetivo General
Desarrollar un proyecto en Java estándar que integre de forma práctica patrones de diseño GoF, aplicándolos en una solución funcional, con justificación técnica clara y una defensa oral argumentada.

📝 Descripción General del Sistema
Este sistema está diseñado para administrar el inventario de medicamentos en una farmacia comunitaria. Permite registrar diferentes tipos de medicamentos, controlar el stock, gestionar fechas de vencimiento, realizar ventas, generar alertas automatizadas y mantener un historial de transacciones.

El problema real que aborda es la gestión ineficiente del inventario, ya que en muchas farmacias este proceso se realiza de forma manual, lo que genera errores, desorden y falta de trazabilidad. Este sistema mejora la precisión, facilita la operación diaria y permite mantener un inventario ordenado, actualizado y auditado.

🧩 Patrones de Diseño Aplicados
🏭 1. Factory Method (Creacional)
¿Por qué?
El sistema debe manejar diferentes tipos de medicamentos (genéricos, controlados, refrigerados), cada uno con sus particularidades. Para evitar una dependencia directa entre el código cliente y las clases concretas, y permitir futuras extensiones, se utiliza el patrón Factory Method.

¿Cómo?
Se implementa una clase fábrica llamada FabricaMedicamentos que recibe los parámetros comunes (nombre, stock, fecha de vencimiento, precio, tipo) y decide qué subclase de Medicamento instanciar.

¿Dónde?
En el método agregarMedicamento() dentro de la clase principal (Main), donde se crea un nuevo medicamento según el tipo indicado por el usuario.

🎁 2. Decorator (Estructural)
¿Por qué?
Durante la venta puede requerirse funcionalidad adicional sin modificar la clase base VentaSimple, como por ejemplo marcar una venta como urgente. El patrón Decorator permite extender dinámicamente el comportamiento sin alterar el código original.

¿Cómo?
La clase VentaImportante implementa la interfaz OperacionDeVenta, envolviendo una instancia de VentaSimple. Al ejecutar, agrega mensajes adicionales antes o después del proceso normal de venta.

¿Dónde?
En el método realizarVenta() del Main, donde se evalúa si la venta es urgente y, en tal caso, se decora dinámicamente la operación de venta con la clase VentaImportante.

👁️ 3. Observer (Comportamental)
¿Por qué?
El sistema debe emitir alertas cuando hay stock bajo o fechas de vencimiento próximas. Para desacoplar el inventario de las alertas y permitir la notificación de múltiples observadores, se utiliza el patrón Observer.

¿Cómo?
SistemaAlerta actúa como sujeto (Subject) que mantiene una lista de observadores (AlertaStock, AlertaVencimiento). Cuando se modifica el stock, se notifica automáticamente a los observadores con el medicamento afectado.

¿Dónde?
En el método realizarVenta(), una vez realizada la operación, se invoca sistemaAlerta.notificar(medicamento) para verificar posibles condiciones de alerta.

🔄 4. Iterator (Libre elección)
¿Por qué?
El inventario contiene una colección de medicamentos que no debe ser expuesta directamente. Para recorrerla de manera segura y encapsulada, se utiliza el patrón Iterator.

¿Cómo?
La clase Inventario implementa el método crearIterador(), que devuelve un objeto IteradorMedicamentos con métodos como tieneSiguiente() y siguiente() para recorrer los elementos uno por uno.

¿Dónde?
Se usa en mostrarMedicamentos() y en simularAlertas() para recorrer todos los medicamentos sin acceder directamente a la estructura de datos interna.

⚙️ Instrucciones de Compilación y Ejecución
Compilación
Desde la raíz del proyecto, ejecutar en consola:

bash
Copiar
Editar
javac -d bin src/**/*.java
Este comando compila todos los archivos .java ubicados dentro de la carpeta src y subcarpetas, y coloca los .class en la carpeta bin.

Ejecución
Una vez compilado, ejecutar:

bash
Copiar
Editar
java -cp bin Main
Esto ejecuta el sistema desde la clase principal.

📁 Estructura del Proyecto
css
Copiar
Editar
INVENTARIOFARMACIA
├── bin/
├── img/
├── src/
│   ├── modelos/
│   │   ├── Inventario.java
│   │   ├── Medicamento.java
│   │   ├── MedicamentoControlado.java
│   │   ├── MedicamentoGenerico.java
│   │   ├── MedicamentoRefrigerado.java
│   │   ├── RegistroVenta.java
│   ├── patrones/
│   │   ├── decorator/
│   │   │   ├── OperacionDeVenta.java
│   │   │   ├── VentaImportante.java
│   │   │   ├── VentaSimple.java
│   │   ├── Factorymethod/
│   │   │   ├── FabricaMedicamentos.java
│   │   ├── iterator/
│   │   │   ├── ColeccionMedicamentos.java
│   │   │   ├── IteradorMedicamentos.java
│   │   ├── observer/
│   │       ├── AlertaStock.java
│   │       ├── AlertaVencimiento.java
│   │       ├── Observer.java
│   │       ├── SistemaAlerta.java
│   │       ├── Subject.java
├── Main.java
💻 Interacción por Consola (CMD)
El programa se ejecuta en consola y ofrece el siguiente menú interactivo:

Registrar medicamentos

Realizar ventas

Mostrar inventario

Buscar medicamentos

Simular alertas por stock o vencimiento

Mostrar historial de ventas

Salir del sistema


























