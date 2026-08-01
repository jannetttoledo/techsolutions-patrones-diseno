# TechSolutions

Proyecto académico de gestión empresarial para pymes, desarrollado en Java con Spring Boot y Maven como parte del curso Patrones de Diseño de Software.

## Descripción

La plataforma TechSolutions permite gestionar productos, inventario, pedidos, pagos y reportes financieros. El proyecto aplica patrones de diseño estructurales y de comportamiento para mejorar la organización, seguridad, extensibilidad y mantenimiento del código.

## Funcionalidades

- Procesamiento de pagos mediante PayPal, Yape y Plin.
- Habilitación o deshabilitación de pasarelas de pago.
- Control de acceso a reportes financieros según el rol del usuario.
- Alertas automáticas cuando el stock de un producto es bajo.
- Configuración del stock mínimo por producto.
- Creación, procesamiento, descuento y cancelación de pedidos.
- Historial de acciones y opción de deshacer cambios en pedidos.
- Estrategias de precio estándar, con descuento y dinámico.
- Catálogo de productos con búsqueda y paginación.

## Patrones de diseño aplicados

- **Adapter:** integración de las pasarelas de pago PayPal, Yape y Plin mediante una interfaz común.
- **Proxy:** control de acceso a reportes financieros según credenciales y roles.
- **Observer:** notificaciones a los roles Gerente y Compras cuando el stock es menor al mínimo configurado.
- **Command:** encapsulación y registro de acciones realizadas sobre los pedidos.
- **Memento:** restauración de estados anteriores de un pedido.
- **Strategy:** selección de políticas de precios estándar, con descuento o dinámico.
- **Iterator:** recorrido, búsqueda y paginación del catálogo de productos.

## Requisitos

- JDK 17 o superior.
- Maven.
- NetBeans IDE, IntelliJ IDEA o Visual Studio Code.
- Git, opcional para clonar el repositorio.

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/Jannettttoledo/techsolutions-patrones-diseño.git
```text

2. Ingresar a la carpeta del proyecto:

```bash
cd techsolutions-patrones-diseño
```text

3. Abrir el proyecto desde NetBeans como proyecto Maven.

4. Esperar a que Maven descargue las dependencias definidas en el archivo `pom.xml`.

## Ejecución

### Desde NetBeans

1. Abrir el proyecto.
2. Buscar la clase principal `TechsolutionsApplication`.
3. Hacer clic derecho sobre la clase.
4. Seleccionar **Run File** o **Run Project**.

### Desde la terminal

Ubicado en la carpeta principal del proyecto, ejecutar:

```bash
mvn spring-boot:run
```text

Luego abrir en el navegador:

```text
http://localhost:8081
```text

## Pruebas

Para ejecutar las pruebas unitarias desde la terminal:

```bash
mvn test
```text

También se pueden ejecutar desde NetBeans haciendo clic derecho sobre la carpeta de pruebas y seleccionando **Test**.

## Integrantes

- Jannett Toledo Castro
- Alexander Rivera del Valle
- Matías Canales Córdova
- Alison Laulate Villa



