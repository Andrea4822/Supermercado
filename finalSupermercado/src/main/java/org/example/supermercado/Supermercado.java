package org.example.supermercado;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Supermercado {
    static Scanner sc =new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("\n\u001B[32m Bienvenido al supermercado las Granjas 👨‍🌾🚜");

        // Definición de Variables
        String id,nombre,descripcion,categoria,nombreProveedor,primeraFoto,segundaFoto;
        Float precioUnitario;
        Long cantidadBodega;
        Boolean caducidad;
        LocalDate fechaDeVencimiento;
        byte opcionMenu;


        // Unión Arrylist y Hashmap

        HashMap<String,Object>yogur=new HashMap<>();
        yogur.put("id","a234f");
        yogur.put("nombre", "Yogudeli");
        yogur.put("descripción","Yogur de fresa semidescremado");
        yogur.put("categoria","lacteos");
        yogur.put("nombreProveedor", "Juana la Marciana");
        yogur.put("primeraFoto","img.yogur");
        yogur.put("segundaFoto","img.yogur2");
        yogur.put("precioUnitario",2000);
        yogur.put("cantidadBodega", 10);
        yogur.put("fechaVencimiento", LocalDate.of(2025, 7, 20));

        HashMap<String,Object>pasta=new HashMap<>();
        pasta.put("id","d2345");
        pasta.put("nombre", "RicaPasta");
        pasta.put("descripción","Pasta 100% artesanal con sémola de trigo");
        pasta.put("categoria","Pastas");
        pasta.put("nombreProveedor", "Pepito el enanito");
        pasta.put("primeraFoto","img.pasta");
        pasta.put("segundaFoto","img.pasta2");
        pasta.put("precioUnitario",3300);
        pasta.put("cantidadBodega", 230);
        pasta.put("fechaVencimiento", LocalDate.of(2025,8,15));


        HashMap<String,Object>almojabana=new HashMap<>();
        almojabana.put("id","e4598");
        almojabana.put("nombre", "AlmojábanaQuesuda");
        almojabana.put("descripción","Almojábana rellena de queso y arequipe");
        almojabana.put("categoria","Panes");
        almojabana.put("nombreProveedor", "Pablo Restrepo");
        almojabana.put("primeraFoto","img.almojabana");
        almojabana.put("segundaFoto","img.almojabana2");
        almojabana.put("precioUnitario",5500);
        almojabana.put("cantidadBodega", 30);
        almojabana.put("fechaVencimiento", LocalDate.of(2026,9,12));


        HashMap<String,Object>gansito=new HashMap<>();
        gansito.put("id","k9876");
        gansito.put("nombre", "BigGansito");
        gansito.put("descripción","Gansito extragrande");
        gansito.put("categoria","Mekato");
        gansito.put("nombreProveedor", "David Palomero");
        gansito.put("primeraFoto","img.gansito");
        gansito.put("segundaFoto","img.gansito2");
        gansito.put("precioUnitario",4900);
        gansito.put("cantidadBodega", 110);
        gansito.put("fechaVencimiento", LocalDate.of(2024,4,23));


        ArrayList<HashMap<String, Object>> productosDetallados = new ArrayList<>();

        productosDetallados.add(yogur);
        productosDetallados.add(pasta);
        productosDetallados.add(almojabana);
        productosDetallados.add(gansito);


        // Menú
        do {
            System.out.println("\n \u001B[33m Menú 🔎" +
                    "\n 1.Inventario de productos 📋" +
                    "\n 2.Eliminar Productos ✖️" +
                    "\n 3.Modificar precios ✂️" +
                    "\n 4.Agregar productos 🔗" +
                    "\n 5.Verificar si el producto está vencido ✨" +
                    "\n 6.salir 👋" +
                    "\n ¿Qué prefieres hacer? 💁‍♀️");
            opcionMenu = sc.nextByte();
            sc.nextLine();

            switch (opcionMenu){
                case 1://Mostrar productos
                    for (int i = 0; i < productosDetallados.size(); i++) {
                        HashMap<String, Object> producto = productosDetallados.get(i);
                        String nombre1 = (String) producto.get("nombre");
                        Integer cantidad = (Integer) producto.get("cantidadBodega");
                        Integer precio = (Integer) producto.get("precioUnitario");

                        System.out.println("🛒\n\u001B[34m " + nombre1 + " \n\u001B[34mCantidad en bodega: " + cantidad + " \n\u001B[34mEl precio por producto es: " + precio);
                    }
                    break;
                case 2://Eliminar producto
                    System.out.print("\n\u001B[34m Ingrese el nombre del producto que desea eliminar: 👀 ");
                    String eliminarProducto = sc.nextLine();

                    boolean eliminado = false;

                    for (int i = 0; i < productosDetallados.size(); i++) {
                        HashMap<String, Object> producto = productosDetallados.get(i);
                        String nombre2 = ((String) producto.get("nombre"));

                        if (nombre2.equalsIgnoreCase(eliminarProducto)) {
                            productosDetallados.remove(i);
                            eliminado = true;
                            System.out.println("\n\u001B[31m Producto eliminado:❌ " + nombre2);
                            break;
                        }
                    }
                    if (!eliminado) {
                        System.out.println("\n\u001B Ese producto no existe en el inventario.");
                    }

                    // Mostrar lista actualizada
                    System.out.println(" \n\u001B[32mLista actualizada: 📋");
                    for (HashMap<String, Object> producto : productosDetallados) {
                        System.out.println("\n\u001B[32m- " + producto.get("nombre"));
                    }
                    break;
                case 3:
                    //Modificar precios
                    System.out.print("\n\u001B[32m Ingrese el nombre del producto para modificar su precio: 😊 ");
                    String productoModificar = sc.nextLine();

                    System.out.print("\n\u001B[32m Ingrese el nuevo precio unitario: 💵 ");
                    int nuevoPrecio = sc.nextInt();
                    sc.nextLine();

                    boolean encontrado = false;

                    for (HashMap<String, Object> producto : productosDetallados) {
                        String nombreProducto = ((String) producto.get("nombre"));

                        if (nombreProducto.equalsIgnoreCase(productoModificar)) {
                            producto.put("precioUnitario", nuevoPrecio);
                            System.out.println("\n\u001B[32m Precio actualizado correctamente para 🙌 " + nombreProducto);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\n\u001B[31m Producto no encontrado. ❌");
                    }
                    break;
                case 4:
                    //Agregar Productos
                    HashMap<String, Object> nuevoProducto = new HashMap<>();

                    System.out.print(" \n\u001B[34m Ingrese el ID del producto: ⌨️ ");
                    nuevoProducto.put("id", sc.nextLine());

                    System.out.print("\n\u001B[34m Ingrese el nombre del producto: ⌨️ ");
                    String nombreNuevo = sc.nextLine();
                    nuevoProducto.put("nombre", nombreNuevo);

                    System.out.print("\n\u001B[34m Ingrese la descripción: ⌨️");
                    nuevoProducto.put("descripción", sc.nextLine());

                    System.out.print("\n\u001B[34m Ingrese la categoría: ⌨️ ");
                    nuevoProducto.put("categoria", sc.nextLine());

                    System.out.print("\n\u001B[34m Ingrese el nombre del proveedor: ⌨️");
                    nuevoProducto.put("nombreProveedor", sc.nextLine());

                    System.out.print("\n\u001B[34m Ingrese el nombre de la primera foto: ⌨️ ");
                    nuevoProducto.put("primeraFoto", sc.nextLine());

                    System.out.print("\n\u001B[34mIngrese el nombre de la segunda foto: ⌨️");
                    nuevoProducto.put("segundaFoto", sc.nextLine());

                    System.out.print("\n\u001B[34m Ingrese el precio unitario: ⌨️ ");
                    nuevoProducto.put("precioUnitario", sc.nextInt());

                    System.out.print("\n\u001B[34m Ingrese la cantidad en bodega: ⌨️ ");
                    nuevoProducto.put("cantidadBodega", sc.nextInt());
                    sc.nextLine();

                    productosDetallados.add(nuevoProducto);

                    System.out.println(" \n\u001B[32mProducto agregado correctamente: 📌 " + nombreNuevo);

                    break;

                case 5:
                    LocalDate hoy = LocalDate.now();
                    List<HashMap<String, Object>> productosArray = Arrays.asList(yogur, pasta, almojabana, gansito);
                    for (HashMap<String, Object> prod : productosArray) {
                        LocalDate fecha = (LocalDate) prod.get("fechaVencimiento");
                        if (fecha != null && fecha.plusDays(3).isBefore(hoy)) {
                            int cant = (int) prod.get("cantidadBodega");
                            if (cant > 0) prod.put("cantidadBodega", cant - 1);
                            System.out.println( prod.get("nombre") + " \u001B[32m vencido hace más de 3 días. -1 unidad.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n\u001B[32m Gracias por visitarnos, nospiii 🤪");
                    break;
            }
        }while (opcionMenu!=6);




        sc.close();



    }
}
