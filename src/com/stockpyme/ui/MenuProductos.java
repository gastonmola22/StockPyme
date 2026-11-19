package com.stockpyme.ui;

import com.stockpyme.model.Producto;

import java.util.Scanner;

public class MenuProductos {
    private Scanner entrada = new Scanner(System.in);
    private Producto[] productos = new Producto[100];
    private int cantidad = 0;

    public void mostrar(){
        int opcion;
        do {
            System.out.println("=== StockPyme - Productos ===");
            System.out.println("1. Alta de producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar por código");
            System.out.println("4. Modificar precio");
            System.out.println("5. Cargar stock (entró mercadería)");
            System.out.println("6. Productos con stock bajo");
            System.out.println("7. Dar de baja producto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpia el Enter

            switch (opcion) {
                case 1: alta(); break;
                case 2: listar();break;
                case 3: buscar(); break;
                case 4: modificarPrecio(); break;
                case 5: cargarStock(); break;
                case 6: listarStockBajo(); break;
                case 7: darDeBaja(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no existe.");
            }
        } while (opcion != 0);
    }
    private void alta() {
        System.out.println("--DANDO DE ALTA---");
        System.out.println("Codigo : ");
        String codigo = entrada.nextLine();
        System.out.println("Nombre : ");
        String nombre = entrada.nextLine();
        System.out.println("Precio : ");
        double precio = entrada.nextDouble();
        System.out.println("Stock : ");
        int stock = entrada.nextInt();
        System.out.println("Stock minimo : ");
        int stockMinimo = entrada.nextInt();
        entrada.nextLine();
        productos[cantidad] = new Producto(codigo, nombre, precio, stock, stockMinimo);
        cantidad++;
        System.out.println("Producto creado correctamente..");

    }
    private void listar() {
        for (int i = 0; i <= cantidad; i++) {
            System.out.println(( ". " + productos[i].getId() + " - " + productos[i].getNombre() + " - " + productos[i].getPrecio()));
        }
    }
    private void buscar() { }
    private void modificarPrecio() { }
    private void cargarStock() { }
    private void listarStockBajo() { }
    private void darDeBaja() { }

}

