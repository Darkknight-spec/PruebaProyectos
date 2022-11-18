package SoftwareInventario;

import com.software.aplicaciondeinventario.OrdenacionAscendente;
import com.software.aplicaciondeinventario.OrdenacionDescendente;
import java.util.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class metodos {

    HashMap<String, Integer> inventario = new HashMap<>();
    TreeMap<String, Integer> inventarioOrdenado;
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion = 0;

       do{
            System.out.println("-------------------------");
            System.out.println("Inventario de productos.");
            System.out.println("-------------------------");
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("\nSeleccione una opción.");
            System.out.println("1. Añadir productos.");
            System.out.println("2. Aumentar cantidad de un producto.");
            System.out.println("3. Eliminar cantidad de un producto");
            System.out.println("4. Listar productos.");
            System.out.println("5. Eliminar un producto.");
            System.out.println("6. Ordenar productos ascendentemente.");
            System.out.println("7. Ordenar productos descendentemente");
            System.out.println("8. Salir del inventario.");
            System.out.println("----------------------------------------");
            try {
                System.out.println("Digite una opcion: ");
                opcion = sc.nextByte();

                int stock, stockActual;

                switch (opcion) {
                    case 1:
                        String nombreProducto;
                        int codigo;
                        
                        System.out.println("Digite el nombre del producto: ");
                        nombreProducto = sc.next();
                        

                        if (inventario.containsKey(nombreProducto)) {
                            System.out.println("Ya existe un producto con ese nombre, ingrese otro nombre.");
                        } else {
                            inventario.put(nombreProducto, 0);
                            System.out.println("Se ha añadido el producto.");
                        }
                        break;
                    case 2:
                        System.out.println("");
                        System.out.print("Digite el nombre del producto: ");
                        nombreProducto = sc.nextLine();

                        if (inventario.containsKey(nombreProducto)) {
                            System.out.print("Digite la cantidad a agregar: ");
                            stock = sc.nextInt();

                            if (stock > 0) {
                                stockActual = inventario.get(nombreProducto);
                                inventario.put(nombreProducto, stockActual + stock);
                                System.out.println("Se ha añadido " + stock + " de cantidad al produtco.");
                            } else {
                                System.out.println("No se puede añadir una cantidad negativa.");
                            }
                        } else {
                            System.out.println("No existe ese producto.");
                        }
                        break;
                    case 3:
                        System.out.println("");
                        System.out.print("Digite el nombre del producto: ");
                        nombreProducto = sc.nextLine();

                        if (inventario.containsKey(nombreProducto)) {
                            System.out.println("Digite la cantidad a eliminar: ");
                            stock = sc.nextInt();

                            if (stock > 0) {
                                stockActual = inventario.get(nombreProducto);

                                if (stockActual > 0) {
                                    inventario.put(nombreProducto, stockActual - stock);
                                    System.out.println("Se ha eliminado " + stock + " elementos al produtco.");
                                }
                            } else {
                                System.out.println("No se puede agregar una cantidad negativa.");
                            }
                        } else {
                            System.out.println("No existe el producto.");
                        }

                        break;
                    case 4:
                        for (String indice : inventario.keySet()) {
                            stock = inventario.get(indice);
                            System.out.println("");
                            System.out.println("Nombre del producto: " + indice);
                            System.out.println("Cantidad: " + stock);
                            System.out.println("");
                        }
                        break;
                    case 5:
                        System.out.println("");
                        System.out.print("Digite el nombre del producto ha eliminar: ");
                        nombreProducto = sc.nextLine();

                        if (inventario.containsKey(nombreProducto)) {
                            inventario.remove(nombreProducto);
                            System.out.println("Producto elimindo");
                        } else {
                            System.out.println("No existe ese producto.");
                        }
                        break;
                    case 6:
                        inventarioOrdenado = new TreeMap<>(new OrdenacionAscendente());
                        inventarioOrdenado.putAll(inventario);

                        for (String indice : inventarioOrdenado.keySet()) {
                            stock = inventarioOrdenado.get(indice);
                            System.out.println("");
                            System.out.println("Nombre Producto: " + indice);
                            System.out.println("Cantidad: " + stock);
                        }
                        break;
                    case 7:
                        inventarioOrdenado = new TreeMap<>(new OrdenacionDescendente());
                        inventarioOrdenado.putAll(inventario);

                        for (String indice : inventarioOrdenado.keySet()) {
                            stock = inventarioOrdenado.get(indice);
                            System.out.println("");
                            System.out.println("Nombre Producto: " + indice);
                            System.out.println("Cantidad: " + stock);
                        }
                        break;
                    case 8:
                        System.out.println("Gracias por participar :) .");
                        opcion = 8;
                        break;

                    default:
                        System.out.println("");
                        System.out.println("Esta opcion no esta disponible.");
                        System.out.println("Vuelva a intentar.");
                        break;

                }
            } catch (InputMismatchException exc) {
                System.out.println("");
                System.out.println("Vuelva a intentar, solo se permiten numeros.");
                Scanner sc = new Scanner(System.in);
            }

        }while(opcion != 8);

    }
}
