# Supermercado
# Supermercado Las Granjas

Bienvenido al proyecto **Supermercado Las Granjas**, una aplicación de consola en Java que permite gestionar un inventario básico de productos para un supermercado.

---

## Descripción

Este programa simula un sistema sencillo de inventario para un supermercado, donde puedes:

- Visualizar el inventario actual de productos.
- Eliminar productos existentes.
- Modificar los precios de los productos.
- Agregar nuevos productos al inventario.
- Verificar si algún producto está vencido y actualizar la cantidad en bodega automáticamente.
- Salir del sistema.

---

## Tecnologías

- Lenguaje: Java
- Manejo de fechas: `java.time.LocalDate`
- Estructuras de datos: `HashMap` y `ArrayList`
- Entrada de usuario: `Scanner`

---

## Cómo funciona

Al iniciar, el programa muestra un menú con las siguientes opciones:

1. **Inventario de productos**: Muestra los productos con su nombre, cantidad en bodega y precio unitario.  
2. **Eliminar productos**: Permite eliminar un producto ingresando su nombre.  
3. **Modificar precios**: Cambiar el precio unitario de un producto existente.  
4. **Agregar productos**: Añadir un nuevo producto al inventario proporcionando sus detalles (id, nombre, descripción, categoría, proveedor, fotos, precio y cantidad).  
5. **Verificar productos vencidos**: Revisa si algún producto está vencido por más de 3 días y, en caso afirmativo, reduce su cantidad en bodega en una unidad.  
6. **Salir**: Termina la ejecución del programa.

---

## Estructura de un producto

Cada producto se representa con un `HashMap<String, Object>` que contiene:

- `id`: Identificador único del producto.
- `nombre`: Nombre del producto.
- `descripción`: Breve descripción.
- `categoria`: Categoría a la que pertenece (lácteos, pastas, panes, etc.).
- `nombreProveedor`: Nombre del proveedor.
- `primeraFoto`: Nombre o ruta de la primera imagen.
- `segundaFoto`
