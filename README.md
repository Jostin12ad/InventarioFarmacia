🎯 Objetivo General
Desarrollar un proyecto en Java libre que integre de forma práctica patrones de diseño GoF, aplicándolos en una solución funcional, con justificación técnica clara y una defensa oral argumentada.

SISTEMA DE GESTION DE FARMACIA

Este sistemalo esta diseñado para administrar el inventario de medicamentos, permite registrar diferentes medicamentos, controlar el stock las fechas de vencimiento, y generar ventas de los medicamentos

El problema real es la gestion ineficiente y el mantener un inventario ordenado que actualmente es manejado de forma manuel propenso a tener errores , con esto mejoramos la precision y facilitamos que la farmacia pueda tener de forma ordenada su inventario de medicamentos

PATRONES OCUPADOS

1) Factory method (CREACIONAL)
¿Porque?
El sistema debe gestionar varios tipos de medicamentos que tienen caracteristicas para mantener el codigo limpio y abierto ocupamos el patron factory method esto evita la dependencia y facilita la extension futura por ejemplo agregar nuevos medicamentos

¿Como?
Tiene una clase fabrica llamada FabricaMedicamentos que recibe parametros comunes (nombre, stock, fecha de vencimiento, precio, tipo) y decide basandose en el tipo, el cliente solo invoca este metodo para obtener un objeto valido sin preocuparse de los detalles de creacion 

¿Donde? 
Al momento de registrar un nuevo medicamento en AgregarMedicamento de la clase principal se usa para fabricar el objeto segun el tipo que seleccione el usuario


2) Decorator (Estructural)

¿Porque? 
En el proceso de venta puede ser necesario agregar funcionalidades adicionales sin alterar la clase de ventaSimple, por ej marcar una venta como urgente el patron decorator permite extender el comportamiento de ejecucion manteniendo la flexibilidad

¿Como?
La clase VentaImportante implementa la misma interfaz que VentaSimple y tiene internamente una referencia a una instancia de OperacionDeVenta. Al llamar a ejecutar() añade un comportamiento antes y después de dejar a la venta original, como imprimir mensajes de urgencia o notificar sistemas

¿Donde?
En el metodo realizarventa del main se realiza si al venta sera simple o importante se utiliza para envolver la venta simple y agregar la funcionalidad adicional sin modificar ventasimple

3) Observer (Comportamental)

¿Porque?
El inventario necesita ciertos detalles importantes como el stock bajo o medicamentos que esten por vencer, usualmente se ocupan alertas automaticas para evitar problemas de salud o algo mas grave, los modulos que manejan alertas se aplica el patron Observer que permite nofiticar multiples eventos que ocurren sin que se conoscan directamente

¿Como?
El sistemaalerta es el sujeto que maantiene una lista al momento de ejecutarse una venta y al momento de reducir el stock cuando se genera la venta el Sistemalaerta notifica del medicamento afectado ya sea del stock o fecha de vencimiento 


¿Donde?
En el metodo realizarventa, tras la modificacion del stock cuando se realiza alguna venta y se resta se invoca sistemaalerta.notificar(med) para generar posible bajo stock o fecha proxima a vencer

4) ITERATOR

¿Porque?
El inventario es una coleccion de medicamentos, para no exponerla estructura ni dejar que el cliente maneje algo de la lista, ademas permite recorrer la coleccion de forma controlada y organizada, se implementa el patron iterator para mejorar la encapsulacion y facilita cambios futuros de la estructura

¿Donde?
La clase inventario provee un metodo creariterator que devuelve un objeto iteradormedicamentos, este iterador tiene metodos para recorrer la coleccion paso a paso sin errores


5) Paso a paso para compilar

1) compilacion ejecutar en consola: javac -d bin src/**/*.java este comando compila todos los .java los cuales estan en la carpeta src con sus carpetas adentro y genera la carpeta BIN

al momento de generar la carpeta BIN con este comando ejecutariamos en consola java -cp bin Main

2) Estructura del proyecto: tenemos codigo fuente en src, archivos compilados en carpeta BIN y clases organizadas segun su funcionalidad(Modelos, patrones etc...)

3) Interaccion el programa se ejecuta por CMD (Consola)
contiene: registrar medicamentos
Realizar ventas
Mostrar inventarios
Buscar medicamentos
Simular las alertas de stock y fehca de vencimiento
mostrar historial de ventas
salir (para finalizar la operacion en consola, CMD)



























