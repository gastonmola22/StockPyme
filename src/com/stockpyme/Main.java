package com.stockpyme;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("----- StockPyme -----");
            System.out.println("1. Productos ");
            System.out.println("2. Categorias ");
            System.out.println("3. Proveedores ");
            System.out.println("4. Clientes ");
            System.out.println("5. Empleados ");
            System.out.println("6  Nueva venta ");
            System.out.println("7. Ventas realizadas ");
            System.out.println("8. Reportes ");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Producto");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no existe...");
            }
        } while (opcion != 0);
    }
}
