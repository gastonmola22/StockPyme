package com.stockpyme;

import com.stockpyme.ui.MenuProductos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        MenuProductos menuProductos = new MenuProductos();
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
                        entrada.nextLine();
                        switch (opcion) {
                            case 1:
                                menuProductos.mostrar();
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

