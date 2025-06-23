# 🩺 Sistema de Gestión de Farmacia

## 🎯 Objetivo General

Desarrollar un proyecto en Java libre que integre de forma práctica patrones de diseño GoF, aplicándolos en una solución funcional, con justificación técnica clara y una defensa oral argumentada.

---

## 🧠 Descripción del Sistema

Este sistema está diseñado para administrar el inventario de medicamentos en una farmacia comunitaria. Permite registrar medicamentos, controlar el stock, fechas de vencimiento, realizar ventas y generar alertas.

> ⚠️ **Problema real**:  
> Muchas farmacias gestionan su inventario de manera manual, lo que conlleva errores, vencimientos no detectados y pérdidas de stock. Este sistema automatiza y mejora la precisión de esa gestión.

---

## 🧩 Patrones de Diseño Aplicados

### 1. 🏭 Factory Method (Creacional)

- **¿Por qué?**  
  Permite crear distintos tipos de medicamentos sin acoplar el código a clases concretas, facilitando su extensión.

- **¿Cómo?**  
  Mediante la clase `FabricaMedicamentos` que recibe los parámetros comunes y retorna un objeto específico (`MedicamentoGenerico`, `Controlado`, etc.).

- **¿Dónde?**  
  En el método `agregarMedicamento()` dentro de `Main`, cuando el usuario registra un nuevo medicamento.

---

### 2. 🎁 Decorator (Estructural)

- **¿Por qué?**  
  Permite extender funcionalidades de una venta (por ejemplo, marcarla como urgente) sin modificar la clase base `VentaSimple`.

- **¿Cómo?**  
  La clase `VentaImportante` envuelve una instancia de `VentaSimple` y agrega nuevos comportamientos al método `ejecutar()`.

- **¿Dónde?**  
  En `realizarVenta()` en `Main`, se decide si la venta es urgente y se aplica el decorador.

---

### 3. 🔔 Observer (Comportamental)

- **¿Por qué?**  
  Se necesita emitir alertas automáticas si el stock es bajo o un medicamento está por vencer. Observer permite desacoplar los módulos.

- **¿Cómo?**  
  `SistemaAlerta` notifica a los observadores (`AlertaStock`, `AlertaVencimiento`) cada vez que se modifica un medicamento.

- **¿Dónde?**  
  En `realizarVenta()`, se llama a `sistemaAlerta.notificar(medicamento)` después de modificar el stock.

---

### 4. 🔄 Iterator (Libre elección)

- **¿Por qué?**  
  Encapsula la forma de recorrer el inventario, sin exponer la lista de medicamentos directamente.

- **¿Cómo?**  
  `Inventario` tiene `crearIterador()`, que retorna un `IteradorMedicamentos` con métodos como `tieneSiguiente()` y `siguiente()`.

- **¿Dónde?**  
  Usado en `mostrarMedicamentos()` y `simularAlertas()` en `Main`.

---

## ⚙️ Instrucciones de Compilación y Ejecución

### 🔧 Compilar

Ejecutar en consola desde la raíz del proyecto:

```bash
javac -d bin (Get-ChildItem -Recurse -Filter *.java -Path .\src | ForEach-Object { $_.FullName })

```

Esto compila todo el código desde la carpeta `src` y lo deposita en `bin`.

### ▶️ Ejecutar

Una vez compilado, correr el sistema con:

```bash
java -cp bin Main
```

---

## 🗂️ Estructura del Proyecto

```
INVENTARIOFARMACIA/
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
```

---

## 🖥️ Funcionalidades por Consola

El sistema es totalmente funcional desde CMD:

- Registrar medicamentos
- Realizar ventas (urgentes o normales)
- Mostrar inventario completo
- Buscar medicamento por nombre
- Simular alertas de vencimiento y stock bajo
- Ver historial de ventas
- Salir del sistema

























