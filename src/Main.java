import models.Pedido;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializa la lista de pedidos pendientes y la pila de pedidos completados
        LinkedList<Pedido> pedidosPendientes = new LinkedList<>();
        Stack<Pedido> pedidosCompletados = new Stack<>();
        int id;
        boolean continuar;
        // Loop principal del programa
        do {
            id=pedidosPendientes.size()+1;
            continuar = menu(pedidosPendientes, pedidosCompletados, id); // Llama a la función "menu" que muestra el menú y gestiona las opciones seleccionadas

        } while (continuar); // Continúa ejecutando el loop mientras "continuar" sea verdadero
    }

    public static boolean menu(LinkedList<Pedido> pedidosPendientes, Stack<Pedido> pedidosCompletados,int id) {

        Scanner teclado = new Scanner(System.in);
        // Muestra el menú
        System.out.println("1. Agregar pedido");
        System.out.println("2. Completar pedido");
        System.out.println("3. Imprimir pedidos pendientes");
        System.out.println("4. Imprimir pedidos completados");
        System.out.println("X. Salir");
        boolean bandera = true;
        //System.out.println(id);
        // Lee la opción seleccionada por el usuario
        String opcion = teclado.next();
        switch (opcion) {
            case "1":
                // Agrega un nuevo pedido
                System.out.println("Ingrese la orden del pedido:");
                ArrayList<String> nuevaOrden = new ArrayList<>();
                String item;
                do {
                    System.out.println("Agregar elemento (o ingrese 'fin' para terminar):");
                    // Lee los elementos de la orden hasta que el usuario ingrese "fin"
                    item = teclado.next();
                    if (!item.equals("fin")) {
                        nuevaOrden.add(item);
                    }
                } while (!item.equals("fin"));
                if (nuevaOrden.isEmpty()) {
                    // Verifica si se agregó al menos un elemento a la orden
                    System.out.println("Debe agregar al menos un elemento a la orden.");
                } else {
                    //System.out.println("AQUI METO UN PEDIDO");
                    // Crea un nuevo pedido y lo agrega a la lista de pedidos pendientes
                    System.out.println(id);
                    Pedido nuevoPedido = new Pedido(id, nuevaOrden);
                    pedidosPendientes.add(nuevoPedido);
                }
                break;
            case "2":
                System.out.println(pedidosPendientes.isEmpty());
                // Completa un pedido
                if (!pedidosPendientes.isEmpty()) {
                    // Verifica si hay pedidos pendientes antes de completar
                    //System.out.println("ENTRÓ");
                    pedidosCompletados.push(completar(pedidosPendientes));
                } else {
                    System.out.println("No hay pedidos pendientes para completar.");
                }
                break;
            case "3":
                // Imprime los pedidos pendientes
                imprimirPendientes(pedidosPendientes);
                break;
            case "4":
                // Imprime los pedidos completados
                imprimirCompletados(pedidosCompletados);
                break;
            default:
                // Sale del programa si se selecciona otra opción
                bandera = false;
                break;
        }
        return bandera;
    }

    public static Pedido completar(LinkedList<Pedido> pedidosPendientes) {
        // Completa un pedido y lo retira de la lista de pedidos pendientes
        return pedidosPendientes.poll();
    }

    public static void imprimirPendientes(LinkedList<Pedido> pedidosPendientes) {
        // Imprime los pedidos pendientes
        System.out.println("Pedidos pendientes: ");
        System.out.println(pedidosPendientes.isEmpty());
        for (Pedido pedido : pedidosPendientes) {
            System.out.println("Pedido #" + pedido.getID() + ": " + pedido.getOrden());
        }
    }

    public static void imprimirCompletados(Stack<Pedido> pedidosCompletados) {
        // Imprime los pedidos completados
        System.out.println("Pedidos completados: ");
        for (Pedido pedido : pedidosCompletados) {
            System.out.println("Pedido #" + pedido.getID() + ": " + pedido.getOrden());
        }
    }
}